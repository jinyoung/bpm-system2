<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
                <v-btn style="margin-left: 5px;" @click="createProcessDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Administrator')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>프로세스 생성
                </v-btn>
                <v-dialog v-model="createProcessDialog" width="500">
                    <CreateProcess
                        @closeDialog="createProcessDialog = false"
                        @createProcess="createProcess"
                    ></CreateProcess>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="modifyProcessDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Administrator')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>프로세스 수정
                </v-btn>
                <v-dialog v-model="modifyProcessDialog" width="500">
                    <ModifyProcess
                        @closeDialog="modifyProcessDialog = false"
                        @modifyProcess="modifyProcess"
                    ></ModifyProcess>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="reviewProcessDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('Administrator')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>프로세스 검토
                </v-btn>
                <v-dialog v-model="reviewProcessDialog" width="500">
                    <ReviewProcess
                        @closeDialog="reviewProcessDialog = false"
                        @reviewProcess="reviewProcess"
                    ></ReviewProcess>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>프로세스명</th>
                        <th>BpmnDefinition</th>
                        <th>Messages</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="프로세스명">{{ val.processName }}</td>
                            <td class="whitespace-nowrap" label="BpmnDefinition">{{ val.bpmnDefinition }}</td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
            <MessageDetailGrid style="margin-top: 20px;" label="Messages" offline v-if="selectedRow" v-model="selectedRow.messages" :selectedRow="selectedRow"/>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Process 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Process :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">Process 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="프로세스 ID" v-model="selectedRow.processId" :editMode="true"/>
                            <String label="프로세스명" v-model="selectedRow.processName" :editMode="true"/>
                            <String label="BpmnDefinition" v-model="selectedRow.bpmnDefinition" :editMode="true"/>
                            <MessageDetailGrid label="Messages" offline v-model="selectedRow.messages" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'
import Process from '../Process.vue'
import String from '../primitives/String.vue'
import MessageDetailGrid from './MessageDetailGrid.vue'
import CreateProcess from '../CreateProcess.vue'
import ModifyProcess from '../ModifyProcess.vue'
import ReviewProcess from '../ReviewProcess.vue'

export default {
    name: 'processGrid',
    mixins:[BaseGrid],
    components:{
        Process,
        String,
        MessageDetailGrid,
        CreateProcess,
        ModifyProcess,
        ReviewProcess,
    },
    data: () => ({
        path: 'processes',
        createProcessDialog: false,
        modifyProcessDialog: false,
        reviewProcessDialog: false,
    }),
    watch: {
    },
    methods:{
        createProcess(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "createProcess", params)
                this.$EventBus.$emit('show-success','CreateProcess 성공적으로 처리되었습니다.')
                this.createProcessDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
        modifyProcess(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "modifyProcess", params)
                this.$EventBus.$emit('show-success','ModifyProcess 성공적으로 처리되었습니다.')
                this.modifyProcessDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
        reviewProcess(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "reviewProcess", params)
                this.$EventBus.$emit('show-success','ReviewProcess 성공적으로 처리되었습니다.')
                this.reviewProcessDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>
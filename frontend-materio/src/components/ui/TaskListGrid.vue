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
                <v-btn style="margin-left: 5px;" @click="completeTaskDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>태스크 완료
                </v-btn>
                <v-dialog v-model="completeTaskDialog" width="500">
                    <CompleteTask
                        @closeDialog="completeTaskDialog = false"
                        @completeTask="completeTask"
                    ></CompleteTask>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>사용자 ID</th>
                        <th>태스크명</th>
                        <th>상태</th>
                        <th>프로세스</th>
                        <th>프로세스 인스턴스</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="사용자 ID">{{ val.userId }}</td>
                            <td class="whitespace-nowrap" label="태스크명">{{ val.taskName }}</td>
                            <td class="whitespace-nowrap" label="상태">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="프로세스">
                                <ProcessId :editMode="editMode" v-model="val.processId"></ProcessId>
                            </td>
                            <td class="whitespace-nowrap" label="프로세스 인스턴스">
                                <InstanceId :editMode="editMode" v-model="val.instanceId"></InstanceId>
                            </td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
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
                        <div style="color:white; font-size:17px; font-weight:700;">TaskList 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <TaskList :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">TaskList 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="태스크 ID" v-model="selectedRow.taskId" :editMode="true"/>
                            <Number label="사용자 ID" v-model="selectedRow.userId" :editMode="true"/>
                            <String label="태스크명" v-model="selectedRow.taskName" :editMode="true"/>
                            <String label="상태" v-model="selectedRow.status" :editMode="true"/>
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
import DrawerContent from '../../../layouts/components/DrawerContent.vue';
import BaseGrid from '../base-ui/BaseGrid.vue'
import TaskList from '../TaskList.vue'
import Number from '../primitives/Number.vue'
import String from '../primitives/String.vue'
import CompleteTask from '../CompleteTask.vue'

export default {
    name: 'taskListGrid',
    mixins:[BaseGrid],
    components:{
        DrawerContent,
        TaskList,
        Number,
        String,
        CompleteTask,
    },
    data: () => ({
        path: 'taskLists',
        completeTaskDialog: false,
    }),
    watch: {
    },
    methods:{
        completeTask(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "completeTask", params)
                this.$EventBus.$emit('show-success','CompleteTask 성공적으로 처리되었습니다.')
                this.completeTaskDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>
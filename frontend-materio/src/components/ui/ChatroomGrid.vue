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
                <v-btn style="margin-left: 5px;" @click="enterChatroomDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>채팅방 입장
                </v-btn>
                <v-dialog v-model="enterChatroomDialog" width="500">
                    <EnterChatroom
                        @closeDialog="enterChatroomDialog = false"
                        @enterChatroom="enterChatroom"
                    ></EnterChatroom>
                </v-dialog>
                <v-btn style="margin-left: 5px;" @click="sendMessageDialog = true" class="contrast-primary-text" small color="primary" :disabled="!hasRole('User')">
                    <v-icon small>mdi-minus-circle-outline</v-icon>메시지 전송
                </v-btn>
                <v-dialog v-model="sendMessageDialog" width="500">
                    <SendMessage
                        @closeDialog="sendMessageDialog = false"
                        @sendMessage="sendMessage"
                    ></SendMessage>
                </v-dialog>
            </div>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>메시지 목록</th>
                        <th>Members</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" :key="val" @click="changeSelectedRow(val)" :style="val === selectedRow ? 'background-color: #f0f3ff;':''">
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <Icon style="margin-top: 15px;" icon="mi:delete" @click="deleteRow(val)" />
                        </tr>
                    </tbody>
                </v-table>
            </div>
            <MessageDetailGrid style="margin-top: 20px;" label="메시지 목록" offline v-if="selectedRow" v-model="selectedRow.messages" :selectedRow="selectedRow"/>
            <MemberDetailGrid style="margin-top: 20px;" label="Members" offline v-if="selectedRow" v-model="selectedRow.members" :selectedRow="selectedRow"/>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Chatroom 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Chatroom :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Chatroom 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="채팅방 ID" v-model="selectedRow.chatroomId" :editMode="true"/>
                            <MessageDetailGrid label="메시지 목록" offline v-model="selectedRow.messages" :editMode="true"/>
                            <MemberDetailGrid label="Members" offline v-model="selectedRow.members" :editMode="true"/>
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
import Chatroom from '../Chatroom.vue'
import MessageDetailGrid from './MessageDetailGrid.vue'
import MemberDetailGrid from './MemberDetailGrid.vue'
import EnterChatroom from '../EnterChatroom.vue'
import SendMessage from '../SendMessage.vue'

export default {
    name: 'chatroomGrid',
    mixins:[BaseGrid],
    components:{
        DrawerContent,
        Chatroom,
        MessageDetailGrid,
        MemberDetailGrid,
        EnterChatroom,
        SendMessage,
    },
    data: () => ({
        path: 'chatrooms',
        enterChatroomDialog: false,
        sendMessageDialog: false,
    }),
    watch: {
    },
    methods:{
        enterChatroom(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "enterChatroom", params)
                this.$EventBus.$emit('show-success','EnterChatroom 성공적으로 처리되었습니다.')
                this.enterChatroomDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
        sendMessage(params){
            try{
                this.repository.invoke(this.getSelectedItem(), "sendMessage", params)
                this.$EventBus.$emit('show-success','SendMessage 성공적으로 처리되었습니다.')
                this.sendMessageDialog = false
            }catch(e){
                console.log(e)
            }
            
        },
    }
}

</script>
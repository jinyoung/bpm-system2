<template>
    <div>
        <Number label="채팅방 ID" v-model="value.chatroomId" :editMode="editMode"/>
        <MessageDetailGrid label="메시지 목록" offline v-model="value.messages" :editMode="editMode" @change="change"/>
        <MemberDetailGrid label="Members" offline v-model="value.members" :editMode="editMode" @change="change"/>

        <v-divider class="border-opacity-100 my-divider"></v-divider>
        <v-layout row justify-end>
            <v-btn
                width="64px"
                color="primary"
                @click="save"
            >
                저장
            </v-btn>
        </v-layout>
    </div>
</template>


<script>

import BaseEntity from './base-ui/BaseEntity.vue'
import Number from './primitives/Number.vue'
import MessageDetailGrid from './ui/MessageDetailGrid.vue'
import MemberDetailGrid from './ui/MemberDetailGrid.vue'

export default {
    name: 'Chatroom',
    mixins:[BaseEntity],
    components:{
        Number,
        MessageDetailGrid,
        MemberDetailGrid,
    },
    
    data: () => ({
        path: "chatrooms"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

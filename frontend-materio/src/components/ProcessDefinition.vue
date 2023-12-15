<template>
    <div>
        <Number label="프로세스 ID" v-model="value.processId" :editMode="editMode"/>
        <String label="프로세스명" v-model="value.processName" :editMode="editMode"/>
        <String label="BpmnDefinition" v-model="value.bpmnDefinition" :editMode="editMode"/>
        <MessageDetailGrid label="Messages" offline v-model="value.messages" :editMode="editMode" @change="change"/>

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
import String from './primitives/String.vue'
import MessageDetailGrid from './ui/MessageDetailGrid.vue'

export default {
    name: 'ProcessDefinition',
    mixins:[BaseEntity],
    components:{
        Number,
        String,
        MessageDetailGrid,
    },
    
    data: () => ({
        path: "processDefinitions"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

<template>
    <div>
        <Number label="태스크 ID" v-model="value.taskId" :editMode="editMode"/>
        <Number label="사용자 ID" v-model="value.userId" :editMode="editMode"/>
        <String label="태스크명" v-model="value.taskName" :editMode="editMode"/>
        <String label="상태" v-model="value.status" :editMode="editMode"/>

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

export default {
    name: 'TaskList',
    mixins:[BaseEntity],
    components:{
        Number,
        String,
    },
    
    data: () => ({
        path: "taskLists"
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>

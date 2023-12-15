<template>

    <v-card outlined>
        <v-card-title>
            CompleteTask
        </v-card-title>

        <v-card-text>
            <UUID offline label="TaskId" v-model="value.taskId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="completeTask"
            >
                CompleteTask
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
import UUID from './UUID.vue'

export default {
    name: 'CompleteTaskCommand',
    components:{
        UUID,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.taskId = {};
    },
    watch: {
    },
    methods: {
        completeTask() {
            this.$emit('completeTask', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>


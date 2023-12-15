<template>
    <v-card outlined>
        <v-card-title>
            CompleteTask
        </v-card-title>

        <v-card-text>
            <Number label="TaskId" v-model="value.taskId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="completeTask"
            >
                CompleteTask
            </v-btn>
            
            <v-btn
                    color="primary"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>
   
    export default {
        name: 'CompleteTaskCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.taskId = 0;
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
                this.$emit('input', this.value);
            },
        }
    }
</script>


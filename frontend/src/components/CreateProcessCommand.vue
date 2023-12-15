<template>
    <v-card outlined>
        <v-card-title>
            CreateProcess
        </v-card-title>

        <v-card-text>
            <String label="ProcessName" v-model="value.processName" :editMode="editMode"/>
            <List&lt;Task&gt; offline label="TaskList" v-model="value.taskList" :editMode="editMode" @change="change"/>
            <TaskList offline label="TaskList" v-model="value.taskList" :editMode="editMode" @change="change"/>
            <List&lt;Permission&gt; offline label="Permissions" v-model="value.permissions" :editMode="editMode" @change="change"/>
            <PermissionList offline label="Permissions" v-model="value.permissions" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createProcess"
            >
                CreateProcess
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
        name: 'CreateProcessCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.processName = '';
            this.value.taskList = [];
            this.value.permissions = [];
        },
        watch: {
        },
        methods: {
            createProcess() {
                this.$emit('createProcess', this.value);
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


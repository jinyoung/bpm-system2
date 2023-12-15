<template>
    <v-card outlined>
        <v-card-title>
            ModifyProcess
        </v-card-title>

        <v-card-text>
            <UUID offline label="ProcessId" v-model="value.processId" :editMode="editMode" @change="change"/>
            <String label="NewProcessName" v-model="value.newProcessName" :editMode="editMode"/>
            <List&lt;Task&gt; offline label="NewTaskList" v-model="value.newTaskList" :editMode="editMode" @change="change"/>
            <TaskList offline label="NewTaskList" v-model="value.newTaskList" :editMode="editMode" @change="change"/>
            <List&lt;Permission&gt; offline label="NewPermissions" v-model="value.newPermissions" :editMode="editMode" @change="change"/>
            <PermissionList offline label="NewPermissions" v-model="value.newPermissions" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="modifyProcess"
            >
                ModifyProcess
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
        name: 'ModifyProcessCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.processId = {};
            this.value.newProcessName = '';
            this.value.newTaskList = [];
            this.value.newPermissions = [];
        },
        watch: {
        },
        methods: {
            modifyProcess() {
                this.$emit('modifyProcess', this.value);
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


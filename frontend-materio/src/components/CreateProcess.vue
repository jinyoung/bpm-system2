<template>

    <v-card outlined>
        <v-card-title>
            CreateProcess
        </v-card-title>

        <v-card-text>
            <String label="ProcessName" v-model="value.processName" :editMode="editMode"/>
            <TaskList offline label="TaskList" v-model="value.taskList" :editMode="editMode" @change="change"/>
            <PermissionList offline label="Permissions" v-model="value.permissions" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createProcess"
            >
                CreateProcess
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
import String from './primitives/String.vue'

export default {
    name: 'CreateProcessCommand',
    components:{
        String,
    },
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
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>


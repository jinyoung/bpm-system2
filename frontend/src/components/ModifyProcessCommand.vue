<template>
    <v-card outlined>
        <v-card-title>
            ModifyProcess
        </v-card-title>

        <v-card-text>
            <Number label="ProcessId" v-model="value.processId" :editMode="editMode"/>
            <String label="NewProcessName" v-model="value.newProcessName" :editMode="editMode"/>
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
            this.value.processId = 0;
            this.value.newProcessName = '';
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


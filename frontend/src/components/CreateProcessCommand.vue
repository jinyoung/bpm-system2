<template>
    <v-card outlined>
        <v-card-title>
            CreateProcess
        </v-card-title>

        <v-card-text>
            <String label="ProcessName" v-model="value.processName" :editMode="editMode"/>
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


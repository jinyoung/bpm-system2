<template>
    <v-card outlined>
        <v-card-title>
            ReviewProcess
        </v-card-title>

        <v-card-text>
            <Number label="ProcessId" v-model="value.processId" :editMode="editMode"/>
            <String label="ReviewResult" v-model="value.reviewResult" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="reviewProcess"
            >
                ReviewProcess
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
        name: 'ReviewProcessCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.processId = 0;
            this.value.reviewResult = '';
        },
        watch: {
        },
        methods: {
            reviewProcess() {
                this.$emit('reviewProcess', this.value);
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


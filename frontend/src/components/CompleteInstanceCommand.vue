<template>
    <v-card outlined>
        <v-card-title>
            CompleteInstance
        </v-card-title>

        <v-card-text>
            <Number label="InstanceId" v-model="value.instanceId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="completeInstance"
            >
                CompleteInstance
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
        name: 'CompleteInstanceCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.instanceId = 0;
        },
        watch: {
        },
        methods: {
            completeInstance() {
                this.$emit('completeInstance', this.value);
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


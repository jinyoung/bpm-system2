<template>
    <v-card outlined>
        <v-card-title>
            ViewInstance
        </v-card-title>

        <v-card-text>
            <UUID offline label="InstanceId" v-model="value.instanceId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="viewInstance"
            >
                ViewInstance
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
        name: 'ViewInstanceCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.instanceId = {};
        },
        watch: {
        },
        methods: {
            viewInstance() {
                this.$emit('viewInstance', this.value);
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


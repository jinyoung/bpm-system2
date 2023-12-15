<template>

    <v-card outlined>
        <v-card-title>
            CreateInstance
        </v-card-title>

        <v-card-text>
            <UUID offline label="ProcessId" v-model="value.processId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createInstance"
            >
                CreateInstance
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
    name: 'CreateInstanceCommand',
    components:{
        UUID,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.processId = {};
    },
    watch: {
    },
    methods: {
        createInstance() {
            this.$emit('createInstance', this.value);
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


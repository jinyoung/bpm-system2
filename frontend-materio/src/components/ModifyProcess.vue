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
                    color="deep-purple lighten-2"
                    text
                    @click="modifyProcess"
            >
                ModifyProcess
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
import Number from './primitives/Number.vue'
import String from './primitives/String.vue'

export default {
    name: 'ModifyProcessCommand',
    components:{
        Number,
        String,
    },
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
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>


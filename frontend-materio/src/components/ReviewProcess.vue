<template>

    <v-card outlined>
        <v-card-title>
            ReviewProcess
        </v-card-title>

        <v-card-text>
            <UUID offline label="ProcessId" v-model="value.processId" :editMode="editMode" @change="change"/>
            <String label="ReviewResult" v-model="value.reviewResult" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="reviewProcess"
            >
                ReviewProcess
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
import String from './primitives/String.vue'

export default {
    name: 'ReviewProcessCommand',
    components:{
        UUID,
        String,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.processId = {};
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
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>


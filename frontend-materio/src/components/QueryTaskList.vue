<template>

    <v-card outlined>
        <v-card-title>
            QueryTaskList
        </v-card-title>

        <v-card-text>
            <UUID offline label="UserId" v-model="value.userId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="queryTaskList"
            >
                QueryTaskList
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
    name: 'QueryTaskListCommand',
    components:{
        UUID,
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = {};
    },
    watch: {
    },
    methods: {
        queryTaskList() {
            this.$emit('queryTaskList', this.value);
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


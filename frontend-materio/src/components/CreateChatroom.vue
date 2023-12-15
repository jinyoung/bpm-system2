<template>

    <v-card outlined>
        <v-card-title>
            CreateChatroom
        </v-card-title>

        <v-card-text>
            <UserList offline label="Members" v-model="value.members" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="createChatroom"
            >
                CreateChatroom
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

export default {
    name: 'CreateChatroomCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.members = [];
    },
    watch: {
    },
    methods: {
        createChatroom() {
            this.$emit('createChatroom', this.value);
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


<template>
    <v-card outlined>
        <v-card-title>
            CreateChatroom
        </v-card-title>

        <v-card-text>
            <List&lt;User&gt; offline label="Members" v-model="value.members" :editMode="editMode" @change="change"/>
            <UserList offline label="Members" v-model="value.members" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="createChatroom"
            >
                CreateChatroom
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
        name: 'CreateChatroomCommand',
        components:{},
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
                this.$emit('input', this.value);
            },
        }
    }
</script>


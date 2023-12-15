<template>
    <v-card outlined>
        <v-card-title>
            EnterChatroom
        </v-card-title>

        <v-card-text>
            <Number label="ChatroomId" v-model="value.chatroomId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="enterChatroom"
            >
                EnterChatroom
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
        name: 'EnterChatroomCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.chatroomId = 0;
        },
        watch: {
        },
        methods: {
            enterChatroom() {
                this.$emit('enterChatroom', this.value);
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


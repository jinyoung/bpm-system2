<template>
    <v-card outlined>
        <v-card-title>
            SendMessage
        </v-card-title>

        <v-card-text>
            <UUID offline label="ChatroomId" v-model="value.chatroomId" :editMode="editMode" @change="change"/>
            <UUID offline label="SenderId" v-model="value.senderId" :editMode="editMode" @change="change"/>
            <String label="Content" v-model="value.content" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="primary"
                    text
                    @click="sendMessage"
            >
                SendMessage
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
        name: 'SendMessageCommand',
        components:{},
        props: {},
        data: () => ({
            editMode: true,
            value: {},
        }),
        created() {
            this.value.chatroomId = {};
            this.value.senderId = {};
            this.value.content = '';
        },
        watch: {
        },
        methods: {
            sendMessage() {
                this.$emit('sendMessage', this.value);
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


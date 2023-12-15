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
                    color="deep-purple lighten-2"
                    text
                    @click="sendMessage"
            >
                SendMessage
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
import UUID from './UUID.vue'
import String from './primitives/String.vue'

export default {
    name: 'SendMessageCommand',
    components:{
        UUID,
        UUID,
        String,
    },
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
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>


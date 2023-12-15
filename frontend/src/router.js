
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import ProcessManagementProcessDefinitionManager from "./components/listers/ProcessManagementProcessDefinitionCards"
import ProcessManagementProcessDefinitionDetail from "./components/listers/ProcessManagementProcessDefinitionDetail"
import ProcessManagementInstanceManager from "./components/listers/ProcessManagementInstanceCards"
import ProcessManagementInstanceDetail from "./components/listers/ProcessManagementInstanceDetail"

import TaskManagementTaskListManager from "./components/listers/TaskManagementTaskListCards"
import TaskManagementTaskListDetail from "./components/listers/TaskManagementTaskListDetail"
import TaskManagementChatroomManager from "./components/listers/TaskManagementChatroomCards"
import TaskManagementChatroomDetail from "./components/listers/TaskManagementChatroomDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/processManagements/processDefinitions',
                name: 'ProcessManagementProcessDefinitionManager',
                component: ProcessManagementProcessDefinitionManager
            },
            {
                path: '/processManagements/processDefinitions/:id',
                name: 'ProcessManagementProcessDefinitionDetail',
                component: ProcessManagementProcessDefinitionDetail
            },
            {
                path: '/processManagements/instances',
                name: 'ProcessManagementInstanceManager',
                component: ProcessManagementInstanceManager
            },
            {
                path: '/processManagements/instances/:id',
                name: 'ProcessManagementInstanceDetail',
                component: ProcessManagementInstanceDetail
            },

            {
                path: '/taskManagements/taskLists',
                name: 'TaskManagementTaskListManager',
                component: TaskManagementTaskListManager
            },
            {
                path: '/taskManagements/taskLists/:id',
                name: 'TaskManagementTaskListDetail',
                component: TaskManagementTaskListDetail
            },
            {
                path: '/taskManagements/chatrooms',
                name: 'TaskManagementChatroomManager',
                component: TaskManagementChatroomManager
            },
            {
                path: '/taskManagements/chatrooms/:id',
                name: 'TaskManagementChatroomDetail',
                component: TaskManagementChatroomDetail
            },



    ]
})

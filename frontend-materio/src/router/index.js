import { createRouter, createWebHashHistory } from 'vue-router';

const router = createRouter({
  history: createWebHashHistory(),
  routes: [
    {
      path: '/',
      component: () => import('../components/pages/Index.vue'),
    },
    {
      path: '/processDefinitions',
      component: () => import('../components/ui/ProcessDefinitionGrid.vue'),
    },
    {
      path: '/instances',
      component: () => import('../components/ui/InstanceGrid.vue'),
    },
    {
      path: '/taskLists',
      component: () => import('../components/ui/TaskListGrid.vue'),
    },
    {
      path: '/chatrooms',
      component: () => import('../components/ui/ChatroomGrid.vue'),
    },
  ],
})

export default router;

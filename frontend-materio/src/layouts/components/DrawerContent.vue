<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: '프로세스 관리' }" />
        <VerticalNavLink
            :item="{
                title: '프로세스',
                to: '/processes',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '프로세스 인스턴스',
                to: '/instances',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: '워크리스트 관리' }" />
        <VerticalNavLink
            :item="{
                title: '태스크 목록',
                to: '/taskLists',
            }"
        />
        <VerticalNavLink
            :item="{
                title: '채팅방',
                to: '/chatrooms',
            }"
        />
    </ul>
</template>

<template>
  <div class="use-contents-part">
    <b-row>
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <b-card header="01" img-src img-alt="image" img-top >
          <b-card-text>저희 사이트는 상대방에게 링크를 전송하고 상대방이 승인을 해준다면 상대방의 위치정보를 확인할 수 있습니다!!</b-card-text>
        </b-card>
      </b-col>
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <b-card header="02" img-src img-alt="image" img-top>
          <b-card-text>방 생성하기를 클릭하고 방 제목과 비밀번호를 설정하여 세션에 참가하세요!!</b-card-text>
        </b-card>
      </b-col>
      <!-- <div class="responsive-w-100"></div> -->
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <b-card header="03" img-src img-alt="image" img-top>
          <b-card-text>방을 생성하고 사이트를 종료하셨어도 방에 참가하실 수 있습니다!! 방 들어가기 버튼을 클릭하여 생성하신 방의 제목과 비밀번호를 입력하면 다시 접속하실 수 있습니다</b-card-text>
        </b-card>
      </b-col>
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <b-card header="04" img-src img-alt="image" img-top>
          <b-card-text>참가한 방의 링크를 상대방에게 공유하면 승인여부에 따라 상대방의 현재 위치를 확인할 수 있습니다</b-card-text>
        </b-card>
      </b-col>
    </b-row>
  </div>
</template>

<script>
export default {
  name: 'MainGrid'
}
</script>

<style scoped>
.use-contents-part{
  margin-top: 130px;
}
.use-contents-part-b-col{
  margin-top: 30px;
}
</style>

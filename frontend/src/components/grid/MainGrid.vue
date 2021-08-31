<template>
  <div class="use-contents-part">
    <b-row>
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <div>
          <p class="contents-header">01</p>
          <img>
          <p>저희 사이트를 이용해서 상대방의 위치를 알아보세요!</p>
        </div>
      </b-col>
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <div>
          <p class="contents-header">02</p>
          <img>
          <p>"방 생성하기"를 누르고 방을 생성한 뒤 세션에 참가하세요!</p>
        </div>
      </b-col>
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <div>
          <p class="contents-header">03</p>
          <img>
          <p>방을 생성하고 사이트를 종료하셨어도 방에 참가하실 수 있습니다!</p>
        </div>
      </b-col>
      <b-col class="use-contents-part-b-col" lg="3" md="6" sm="6" xs="12" style="min-width: 150px">
        <div>
          <p class="contents-header">04</p>
          <img>
          <p>참가한 방의 링크를 상대방에게 공유하여 상대방의 현재 위치를 확인하세요!</p>
        </div>
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
.contents-header {
  text-align: center;
  margin: 0px;
  font-size: 1.2em;
  font-weight: bold;
  background-color: rgba(248, 249, 250, 1);
}
</style>

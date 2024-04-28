<template>
  <form  @submit.prevent="sendFile" enctype="multipart/form-data">
    <div class="field">

      <div><label for="file" class="label">Upload File </label></div>

      <input
        type="file"
        ref="file"
        @change="selectFile"

      />
      <div><label type="text" class="label">Upload Plus Code</label></div>
      <div>
        <input
          :value="text"
          ref="plusCode"
          @input="selectPlusCode"
        />
      </div>

      <div><label type="text" class="label">Upload Bird Code </label></div>
      <div>
        <input
          :value="text"
          ref="birdCode"
          @input="selectBirdCode"
        />
      </div>
    </div>

    <div class="field">
      <button class="button is-info">Send</button>
    </div>
  </form>
</template>


<script>
import axios from 'axios';

export default {
  name:"SimpleUpload",
  data() {
    return {
      file: "",
      plusCode: "",
      birdCode: ""
    }
  },

  methods: {
    selectFile() {
      this.file = this.$refs.file.files[0];
      console.log("is this working?")
    },

    selectPlusCode() {
      this.plusCode = this.$refs.plusCode.value;
      console.log("Plus code " + this.plusCode)
    },
    selectBirdCode() {
      this.birdCode = this.$refs.birdCode.value;
      console.log("Bird code " + this.birdCode)
    },

    async sendFile(){
      const formData = new FormData();
      formData.append('file', this.file)
      formData.append('birdCode', this.birdCode)
      formData.append('plusCode', this.plusCode)
      try {
        await axios.post('/upload', formData)
        console.log("file uploaded!")
      } catch (err){
        console.log(err);
      }
    }
  }
}



</script>

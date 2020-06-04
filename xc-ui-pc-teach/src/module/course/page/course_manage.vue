<template>
  <div>

    <el-menu
      :default-active="activeIndex"
      class="el-menu-demo"
      mode="horizontal"
      background-color="#eee"
      text-color="#000"
      active-text-color="#000">
      <router-link class="mui-tab-item" :to="{path:'/course/manage/summary/'+this.courseid}">
      <el-menu-item index="1">课程首页</el-menu-item>
      </router-link>
      <router-link class="mui-tab-item" :to="{path:'/course/manage/baseinfo/'+this.courseid}">
      <el-menu-item index="2">基本信息</el-menu-item>
      </router-link>
      <router-link class="mui-tab-item" :to="{path:'/course/manage/picture/'+this.courseid}">
        <el-menu-item index="3">课程图片</el-menu-item>
      </router-link>
      <router-link class="mui-tab-item" :to="{path:'/course/manage/marketinfo/'+this.courseid}">
      <el-menu-item index="4">课程营销</el-menu-item>
      </router-link>
      <router-link class="mui-tab-item" :to="{path:'/course/manage/plan/'+this.courseid}">
      <el-menu-item index="5">课程计划</el-menu-item>
      </router-link>
      <router-link class="mui-tab-item" :to="{path:'/course/manage/teacher/'+this.courseid}">
        <el-menu-item index="6">教师信息</el-menu-item>
      </router-link>
      <router-link class="mui-tab-item" :to="{path:'/course/manage/pub/'+this.courseid}">
        <el-menu-item index="7">发布课程</el-menu-item>
      </router-link>
    </el-menu>
    <router-view class="main"></router-view>
  </div>
</template>
<script>
  import * as courseApi from '../api/course';
  import utilApi from '../../../common/utils';
  import * as systemApi from '../../../base/api/system';
  export default {
    data() {
      return {
        activeIndex:'2',
        courseid:''
      }
    },
    methods: {
      save () {
        //修改课程
        this.$refs.courseForm.validate((valid) => {
          if (valid) {
            this.$confirm('确认提交吗？', '提示', {}).then(() => {
              let mt = this.categoryActive[0];
              let st = this.categoryActive[1];
              this.courseForm.mt = mt;
              this.courseForm.st = st;
              let id = this.courseForm.id
              courseApi.updateCoursebase(id,this.courseForm).then((res) => {
                if(res.success){
                  this.$message({
                    message: '提交成功',
                    type: 'success'
                  });
                }else{
                  if(res.message){
                    this.$message.error(res.message);
                  }else{
                    this.$message.error('提交失败');
                  }
                }
              });
            });
          }
        });
      }
    },
    mounted(){
      //查询数据字典字典
      systemApi.sys_getDictionary('201').then((res) => {
        // console.log(res);
        this.studymodelList = res.dvalue;
      });
      systemApi.sys_getDictionary('200').then((res) => {
        this.gradeList = res.dvalue;
      });
      //取课程分类
      courseApi.category_findlist({}).then((res) => {
        this.categoryList = res.children;
      });
      courseApi.getCoursebaseById(this.courseid).then((res) => {
        // console.log(res);
        this.courseForm = res;
        //课程分类显示，需要两级分类
        this.categoryActive.push(this.courseForm.mt);
        this.categoryActive.push(this.courseForm.st);
      });
      //课程id
      this.courseid = this.$route.params.courseid

      console.log("courseid=" + this.courseid)
      //跳转到课程基本信息
      this.$router.push({ path: '/course/manage/baseinfo/'+this.courseid})

    }
  }
</script>
<style scoped>


</style>

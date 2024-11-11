<template>
  <div class="addEdit-block">
    <el-form
      class="detail-form-content"
      ref="ruleForm"
      :model="ruleForm"
      :rules="rules"
      label-width="80px"
	  :style="{backgroundColor:addEditForm.addEditBoxColor}"
    >
      <el-row>
                        <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'" label="预约编号" prop="yuyuebianhao">
            <el-input v-model="ruleForm.yuyuebianhao" 
                placeholder="预约编号" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.yuyuebianhao" label="预约编号" prop="yuyuebianhao">
              <el-input v-model="ruleForm.yuyuebianhao" 
                placeholder="预约编号" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房屋名称" prop="fangwumingcheng">
          <el-input v-model="ruleForm.fangwumingcheng" 
              placeholder="房屋名称" clearable  :readonly="ro.fangwumingcheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房屋名称" prop="fangwumingcheng">
              <el-input v-model="ruleForm.fangwumingcheng" 
                placeholder="房屋名称" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房屋类型" prop="fangwuleixing">
          <el-input v-model="ruleForm.fangwuleixing" 
              placeholder="房屋类型" clearable  :readonly="ro.fangwuleixing"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房屋类型" prop="fangwuleixing">
              <el-input v-model="ruleForm.fangwuleixing" 
                placeholder="房屋类型" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="24">  
        <el-form-item class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian">
          <file-upload
          tip="点击上传图片"
          action="file/upload"
          :limit="3"
          :multiple="true"
          :fileUrls="ruleForm.tupian?ruleForm.tupian:''"
          @change="tupianUploadChange"
          ></file-upload>
        </el-form-item>
        <div v-else>
          <el-form-item v-if="ruleForm.tupian" label="图片" prop="tupian">
            <img style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="item" width="100" height="100">
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="面积" prop="mianji">
          <el-input v-model="ruleForm.mianji" 
              placeholder="面积" clearable  :readonly="ro.mianji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="面积" prop="mianji">
              <el-input v-model="ruleForm.mianji" 
                placeholder="面积" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="房屋状态" prop="fangwuzhuangtai">
          <el-input v-model="ruleForm.fangwuzhuangtai" 
              placeholder="房屋状态" clearable  :readonly="ro.fangwuzhuangtai"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="房屋状态" prop="fangwuzhuangtai">
              <el-input v-model="ruleForm.fangwuzhuangtai" 
                placeholder="房屋状态" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="小区" prop="xiaoqu">
          <el-input v-model="ruleForm.xiaoqu" 
              placeholder="小区" clearable  :readonly="ro.xiaoqu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="小区" prop="xiaoqu">
              <el-input v-model="ruleForm.xiaoqu" 
                placeholder="小区" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="月租价格" prop="yuezujiage">
          <el-input v-model="ruleForm.yuezujiage" 
              placeholder="月租价格" clearable  :readonly="ro.yuezujiage"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="月租价格" prop="yuezujiage">
              <el-input v-model="ruleForm.yuezujiage" 
                placeholder="月租价格" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="租赁月数" prop="zulinyueshu">
          <el-input v-model="ruleForm.zulinyueshu" 
              placeholder="租赁月数" clearable  :readonly="ro.zulinyueshu"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="租赁月数" prop="zulinyueshu">
              <el-input v-model="ruleForm.zulinyueshu" 
                placeholder="租赁月数" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="租赁金额" prop="zulinjine">
            <el-input v-model="zulinjine"
                placeholder="租赁金额" readonly></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.zulinjine" label="租赁金额" prop="zulinjine">
              <el-input v-model="ruleForm.zulinjine" 
                placeholder="租赁金额" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="押金" prop="yajin">
          <el-input v-model="ruleForm.yajin" 
              placeholder="押金" clearable  :readonly="ro.yajin"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="押金" prop="yajin">
              <el-input v-model="ruleForm.yajin" 
                placeholder="押金" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="date" v-if="type!='info'" label="预约日期" prop="yuyueriqi">
            <el-date-picker
                value-format="yyyy-MM-dd HH:mm:ss"
                v-model="ruleForm.yuyueriqi" 
                type="datetime"
                placeholder="预约日期">
            </el-date-picker>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" v-if="ruleForm.yuyueriqi" label="预约日期" prop="yuyueriqi">
              <el-input v-model="ruleForm.yuyueriqi" 
                placeholder="预约日期" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="用户名" prop="yonghuming">
          <el-input v-model="ruleForm.yonghuming" 
              placeholder="用户名" clearable  :readonly="ro.yonghuming"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="用户名" prop="yonghuming">
              <el-input v-model="ruleForm.yonghuming" 
                placeholder="用户名" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="手机" prop="shouji">
          <el-input v-model="ruleForm.shouji" 
              placeholder="手机" clearable  :readonly="ro.shouji"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="手机" prop="shouji">
              <el-input v-model="ruleForm.shouji" 
                placeholder="手机" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                    <el-col :span="12">
        <el-form-item class="input" v-if="type!='info'"  label="身份证" prop="shenfenzheng">
          <el-input v-model="ruleForm.shenfenzheng" 
              placeholder="身份证" clearable  :readonly="ro.shenfenzheng"></el-input>
        </el-form-item>
        <div v-else>
          <el-form-item class="input" label="身份证" prop="shenfenzheng">
              <el-input v-model="ruleForm.shenfenzheng" 
                placeholder="身份证" readonly></el-input>
          </el-form-item>
        </div>
      </el-col>
                                                                                          </el-row>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              <el-form-item class="btn">
                <el-button v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">提交</el-button>
        <el-button v-if="type!='info'" class="btn-close" @click="back()">取消</el-button>
        <el-button v-if="type=='info'" class="btn-close" @click="back()">返回</el-button>
      </el-form-item>
    </el-form>
    
    
  </div>
</template>
<script>
// 数字，邮件，手机，url，身份证校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
  data() {
    let self = this
    var validateIdCard = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!checkIdCard(value)) {
        callback(new Error("请输入正确的身份证号码"));
      } else {
        callback();
      }
    };
    var validateUrl = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isURL(value)) {
        callback(new Error("请输入正确的URL地址"));
      } else {
        callback();
      }
    };
    var validateMobile = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isMobile(value)) {
        callback(new Error("请输入正确的手机号码"));
      } else {
        callback();
      }
    };
    var validatePhone = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isPhone(value)) {
        callback(new Error("请输入正确的电话号码"));
      } else {
        callback();
      }
    };
    var validateEmail = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isEmail(value)) {
        callback(new Error("请输入正确的邮箱地址"));
      } else {
        callback();
      }
    };
    var validateNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isNumber(value)) {
        callback(new Error("请输入数字"));
      } else {
        callback();
      }
    };
    var validateIntNumber = (rule, value, callback) => {
      if(!value){
        callback();
      } else if (!isIntNumer(value)) {
        callback(new Error("请输入整数"));
      } else {
        callback();
      }
    };
    return {
	  addEditForm: {"btnSaveFontColor":"#fff","selectFontSize":"14px","btnCancelBorderColor":"#DCDFE6","inputBorderRadius":"4px","inputFontSize":"14px","textareaBgColor":"#fff","btnSaveFontSize":"14px","textareaBorderRadius":"4px","uploadBgColor":"#fff","textareaBorderStyle":"solid","btnCancelWidth":"88px","textareaHeight":"120px","dateBgColor":"#fff","btnSaveBorderRadius":"4px","uploadLableFontSize":"14px","textareaBorderWidth":"1px","inputLableColor":"rgba(131, 138, 182, 1)","addEditBoxColor":"#fff","dateIconFontSize":"14px","btnSaveBgColor":"rgba(84, 88, 179, 1)","uploadIconFontColor":"#8c939d","textareaBorderColor":"rgba(236, 236, 255, 1)","btnCancelBgColor":"rgba(255, 255, 255, 1)","selectLableColor":"rgba(131, 138, 182, 1)","btnSaveBorderStyle":"solid","dateBorderWidth":"1px","dateLableFontSize":"14px","dateBorderRadius":"4px","btnCancelBorderStyle":"solid","selectLableFontSize":"14px","selectBorderStyle":"solid","selectIconFontColor":"rgba(236, 236, 255, 1)","btnCancelHeight":"44px","inputHeight":"38px","btnCancelFontColor":"rgba(0, 0, 0, 1)","dateBorderColor":"rgba(236, 236, 255, 1)","dateIconFontColor":"rgba(0, 0, 0, 1)","uploadBorderStyle":"dashed","dateBorderStyle":"solid","dateLableColor":"rgba(131, 138, 182, 1)","dateFontSize":"14px","inputBorderWidth":"1px","uploadIconFontSize":"28px","selectHeight":"38px","inputFontColor":"rgba(119, 122, 178, 1)","uploadHeight":"148px","textareaLableColor":"rgba(131, 138, 182, 1)","textareaLableFontSize":"14px","btnCancelFontSize":"14px","inputBorderStyle":"solid","btnCancelBorderRadius":"4px","inputBgColor":"rgba(255, 255, 255, 1)","inputLableFontSize":"14px","uploadLableColor":"rgba(131, 138, 182, 1)","uploadBorderRadius":"4px","btnSaveHeight":"44px","selectBgColor":"#fff","btnSaveWidth":"88px","selectIconFontSize":"14px","dateHeight":"38px","selectBorderColor":"rgba(236, 236, 255, 1)","inputBorderColor":"rgba(236, 236, 255, 1)","uploadBorderColor":"rgba(236, 236, 255, 1)","textareaFontColor":"rgba(119, 122, 178, 1)","selectBorderWidth":"1px","dateFontColor":"rgba(119, 122, 178, 1)","btnCancelBorderWidth":"0px","uploadBorderWidth":"2px","textareaFontSize":"14px","selectBorderRadius":"4px","selectFontColor":"rgba(119, 122, 178, 1)","btnSaveBorderColor":"#409EFF","btnSaveBorderWidth":"0px"},
      id: '',
      type: '',
      ro:{
	yuyuebianhao : false,
	fangwumingcheng : false,
	fangwuleixing : false,
	tupian : false,
	mianji : false,
	fangwuzhuangtai : false,
	xiaoqu : false,
	yuezujiage : false,
	zulinyueshu : false,
	zulinjine : false,
	yajin : false,
	yuyueriqi : false,
	yonghuming : false,
	shouji : false,
	shenfenzheng : false,
	sfsh : false,
	shhf : false,
      },
            ruleForm: {
                        yuyuebianhao: this.getUUID(),
                        	        fangwumingcheng: '',
	                        	        fangwuleixing: '',
	                        	        tupian: '',
	                        	        mianji: '',
	                        	        fangwuzhuangtai: '',
	                        	        xiaoqu: '',
	                        	        yuezujiage: '',
	                        	        zulinyueshu: '',
	                        	        zulinjine: '',
	                        	        yajin: '',
	                        	        yuyueriqi: '',
	                        	        yonghuming: '',
	                        	        shouji: '',
	                        	        shenfenzheng: '',
	                        	                        	        shhf: '',
	                      },
                                                                                                                                                                                                                                                          rules: {
                  yuyuebianhao: [
                                    	                                                              ],
                  fangwumingcheng: [
                                    	                                                              ],
                  fangwuleixing: [
                                    	                                                              ],
                  tupian: [
                                    	                                                              ],
                  mianji: [
                                    	                                                              ],
                  fangwuzhuangtai: [
                                    	                                                              ],
                  xiaoqu: [
                                    	                                                              ],
                  yuezujiage: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                        	                                                              ],
                  zulinyueshu: [
                                        { validator: validateIntNumber, trigger: 'blur' },
                        	                                                              ],
                  zulinjine: [
                                    	                                                              ],
                  yajin: [
                                    	                                                              ],
                  yuyueriqi: [
                                    	                                                              ],
                  yonghuming: [
                                    	                                                              ],
                  shouji: [
                                    	                                                              ],
                  shenfenzheng: [
                                    	                                                              ],
                  sfsh: [
                                    	                                                              ],
                  shhf: [
                                    	                                                              ],
              }
    };
  },
  props: ["parent"],
  computed: {
                                                                                                                        zulinjine:{
                                                                                                                                                                                                                                                                          get: function () {
        return 1*this.ruleForm.yuezujiage*this.ruleForm.zulinyueshu
      }
    },
                                                                                                  },
  created() {
	this.addEditStyleChange()
	this.addEditUploadStyleChange()
  },
  methods: {
        // 下载
    download(file){
      window.open(`${file}`)
    },
    // 初始化
    init(id,type) {
      if (id) {
        this.id = id;
        this.type = type;
      }
      if(this.type=='info'||this.type=='else'){
        this.info(id);
      }else if(this.type=='cross'){
        var obj = this.$storage.getObj('crossObj');
        for (var o in obj){
          	            if(o=='yuyuebianhao'){
            this.ruleForm.yuyuebianhao = obj[o];
	    this.ro.yuyuebianhao = true;
            continue;
          }
	            	            if(o=='fangwumingcheng'){
            this.ruleForm.fangwumingcheng = obj[o];
	    this.ro.fangwumingcheng = true;
            continue;
          }
	            	            if(o=='fangwuleixing'){
            this.ruleForm.fangwuleixing = obj[o];
	    this.ro.fangwuleixing = true;
            continue;
          }
	            	            if(o=='tupian'){
            this.ruleForm.tupian = obj[o];
	    this.ro.tupian = true;
            continue;
          }
	            	            if(o=='mianji'){
            this.ruleForm.mianji = obj[o];
	    this.ro.mianji = true;
            continue;
          }
	            	            if(o=='fangwuzhuangtai'){
            this.ruleForm.fangwuzhuangtai = obj[o];
	    this.ro.fangwuzhuangtai = true;
            continue;
          }
	            	            if(o=='xiaoqu'){
            this.ruleForm.xiaoqu = obj[o];
	    this.ro.xiaoqu = true;
            continue;
          }
	            	            if(o=='yuezujiage'){
            this.ruleForm.yuezujiage = obj[o];
	    this.ro.yuezujiage = true;
            continue;
          }
	            	            if(o=='zulinyueshu'){
            this.ruleForm.zulinyueshu = obj[o];
	    this.ro.zulinyueshu = true;
            continue;
          }
	            	            if(o=='zulinjine'){
            this.ruleForm.zulinjine = obj[o];
	    this.ro.zulinjine = true;
            continue;
          }
	            	            if(o=='yajin'){
            this.ruleForm.yajin = obj[o];
	    this.ro.yajin = true;
            continue;
          }
	            	            if(o=='yuyueriqi'){
            this.ruleForm.yuyueriqi = obj[o];
	    this.ro.yuyueriqi = true;
            continue;
          }
	            	            if(o=='yonghuming'){
            this.ruleForm.yonghuming = obj[o];
	    this.ro.yonghuming = true;
            continue;
          }
	            	            if(o=='shouji'){
            this.ruleForm.shouji = obj[o];
	    this.ro.shouji = true;
            continue;
          }
	            	            if(o=='shenfenzheng'){
            this.ruleForm.shenfenzheng = obj[o];
	    this.ro.shenfenzheng = true;
            continue;
          }
	            	            	                    }
                                                                                                                                                                                                                                                                                              }
            // 获取用户信息
      this.$http({
        url: `${this.$storage.get('sessionTable')}/session`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
          var json = data.data;
                                                                                                                                                                                                                                                                                              		if(json.yonghuming!=''&&json.yonghuming){
              		this.ruleForm.yonghuming = json.yonghuming
		}
                                  		if(json.shouji!=''&&json.shouji){
              		this.ruleForm.shouji = json.shouji
		}
                                  		if(json.shenfenzheng!=''&&json.shenfenzheng){
              		this.ruleForm.shenfenzheng = json.shenfenzheng
		}
                                                                          } else {
          this.$message.error(data.msg);
        }
      });
                                                                                                                                                                                                                                                                                                                                                },
                                                                                                                                                // 多级联动参数
                                                                                                                                                                                      info(id) {
      this.$http({
        url: `yuyuekanfang/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
	//解决前台上传图片后台不显示的问题
	let reg=new RegExp('../../../upload','g')//g代表全部
        } else {
          this.$message.error(data.msg);
        }
      });
    },
        // 提交
    onSubmit() {
                  // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
              this.ruleForm.zulinjine = this.zulinjine
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                              // ${column.compare}
                                                                                                                                                                                                                                                                                                                                                      this.$refs["ruleForm"].validate(valid => {
        if (valid) {
          this.$http({
            url: `yuyuekanfang/${!this.ruleForm.id ? "save" : "update"}`,
            method: "post",
            data: this.ruleForm
          }).then(({ data }) => {
            if (data && data.code === 0) {
              this.$message({
                message: "操作成功",
                type: "success",
                duration: 1500,
                onClose: () => {
                  this.parent.showFlag = true;
                  this.parent.addOrUpdateFlag = false;
                  this.parent.yuyuekanfangCrossAddOrUpdateFlag = false;
                  this.parent.search();
                  this.parent.contentStyleChange();
                }
              });
            } else {
              this.$message.error(data.msg);
            }
          });
        }
      });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // 返回
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.yuyuekanfangCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
                                                            tupianUploadChange(fileUrls) {
                this.ruleForm.tupian = fileUrls;
				this.addEditUploadStyleChange()
            },
                                                                                                                                                                        	addEditStyleChange() {
	  this.$nextTick(()=>{
	    // input
	    document.querySelectorAll('.addEdit-block .input .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputFontColor
	      el.style.fontSize = this.addEditForm.inputFontSize
	      el.style.borderWidth = this.addEditForm.inputBorderWidth
	      el.style.borderStyle = this.addEditForm.inputBorderStyle
	      el.style.borderColor = this.addEditForm.inputBorderColor
	      el.style.borderRadius = this.addEditForm.inputBorderRadius
	      el.style.backgroundColor = this.addEditForm.inputBgColor
	    })
	    document.querySelectorAll('.addEdit-block .input .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.inputHeight
	      el.style.color = this.addEditForm.inputLableColor
	      el.style.fontSize = this.addEditForm.inputLableFontSize
	    })
	    // select
	    document.querySelectorAll('.addEdit-block .select .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectFontColor
	      el.style.fontSize = this.addEditForm.selectFontSize
	      el.style.borderWidth = this.addEditForm.selectBorderWidth
	      el.style.borderStyle = this.addEditForm.selectBorderStyle
	      el.style.borderColor = this.addEditForm.selectBorderColor
	      el.style.borderRadius = this.addEditForm.selectBorderRadius
	      el.style.backgroundColor = this.addEditForm.selectBgColor
	    })
	    document.querySelectorAll('.addEdit-block .select .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.selectHeight
	      el.style.color = this.addEditForm.selectLableColor
	      el.style.fontSize = this.addEditForm.selectLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .select .el-select__caret').forEach(el=>{
	      el.style.color = this.addEditForm.selectIconFontColor
	      el.style.fontSize = this.addEditForm.selectIconFontSize
	    })
	    // date
	    document.querySelectorAll('.addEdit-block .date .el-input__inner').forEach(el=>{
	      el.style.height = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateFontColor
	      el.style.fontSize = this.addEditForm.dateFontSize
	      el.style.borderWidth = this.addEditForm.dateBorderWidth
	      el.style.borderStyle = this.addEditForm.dateBorderStyle
	      el.style.borderColor = this.addEditForm.dateBorderColor
	      el.style.borderRadius = this.addEditForm.dateBorderRadius
	      el.style.backgroundColor = this.addEditForm.dateBgColor
	    })
	    document.querySelectorAll('.addEdit-block .date .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.dateHeight
	      el.style.color = this.addEditForm.dateLableColor
	      el.style.fontSize = this.addEditForm.dateLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .date .el-input__icon').forEach(el=>{
	      el.style.color = this.addEditForm.dateIconFontColor
	      el.style.fontSize = this.addEditForm.dateIconFontSize
	      el.style.lineHeight = this.addEditForm.dateHeight
	    })
	    // upload
	    let iconLineHeight = parseInt(this.addEditForm.uploadHeight) - parseInt(this.addEditForm.uploadBorderWidth) * 2 + 'px'
	    document.querySelectorAll('.addEdit-block .upload .el-upload--picture-card').forEach(el=>{
	      el.style.width = this.addEditForm.uploadHeight
	      el.style.height = this.addEditForm.uploadHeight
	      el.style.borderWidth = this.addEditForm.uploadBorderWidth
	      el.style.borderStyle = this.addEditForm.uploadBorderStyle
	      el.style.borderColor = this.addEditForm.uploadBorderColor
	      el.style.borderRadius = this.addEditForm.uploadBorderRadius
	      el.style.backgroundColor = this.addEditForm.uploadBgColor
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-form-item__label').forEach(el=>{
	      el.style.lineHeight = this.addEditForm.uploadHeight
	      el.style.color = this.addEditForm.uploadLableColor
	      el.style.fontSize = this.addEditForm.uploadLableFontSize
	    })
	    document.querySelectorAll('.addEdit-block .upload .el-icon-plus').forEach(el=>{
	      el.style.color = this.addEditForm.uploadIconFontColor
	      el.style.fontSize = this.addEditForm.uploadIconFontSize
	      el.style.lineHeight = iconLineHeight
	      el.style.display = 'block'
	    })
	    // 多文本输入框
	    document.querySelectorAll('.addEdit-block .textarea .el-textarea__inner').forEach(el=>{
	      el.style.height = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaFontColor
	      el.style.fontSize = this.addEditForm.textareaFontSize
	      el.style.borderWidth = this.addEditForm.textareaBorderWidth
	      el.style.borderStyle = this.addEditForm.textareaBorderStyle
	      el.style.borderColor = this.addEditForm.textareaBorderColor
	      el.style.borderRadius = this.addEditForm.textareaBorderRadius
	      el.style.backgroundColor = this.addEditForm.textareaBgColor
	    })
	    document.querySelectorAll('.addEdit-block .textarea .el-form-item__label').forEach(el=>{
	      // el.style.lineHeight = this.addEditForm.textareaHeight
	      el.style.color = this.addEditForm.textareaLableColor
	      el.style.fontSize = this.addEditForm.textareaLableFontSize
	    })
	    // 保存
	    document.querySelectorAll('.addEdit-block .btn .btn-success').forEach(el=>{
	      el.style.width = this.addEditForm.btnSaveWidth
	      el.style.height = this.addEditForm.btnSaveHeight
	      el.style.color = this.addEditForm.btnSaveFontColor
	      el.style.fontSize = this.addEditForm.btnSaveFontSize
	      el.style.borderWidth = this.addEditForm.btnSaveBorderWidth
	      el.style.borderStyle = this.addEditForm.btnSaveBorderStyle
	      el.style.borderColor = this.addEditForm.btnSaveBorderColor
	      el.style.borderRadius = this.addEditForm.btnSaveBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnSaveBgColor
	    })
	    // 返回
	    document.querySelectorAll('.addEdit-block .btn .btn-close').forEach(el=>{
	      el.style.width = this.addEditForm.btnCancelWidth
	      el.style.height = this.addEditForm.btnCancelHeight
	      el.style.color = this.addEditForm.btnCancelFontColor
	      el.style.fontSize = this.addEditForm.btnCancelFontSize
	      el.style.borderWidth = this.addEditForm.btnCancelBorderWidth
	      el.style.borderStyle = this.addEditForm.btnCancelBorderStyle
	      el.style.borderColor = this.addEditForm.btnCancelBorderColor
	      el.style.borderRadius = this.addEditForm.btnCancelBorderRadius
	      el.style.backgroundColor = this.addEditForm.btnCancelBgColor
	    })
	  })
	},
	addEditUploadStyleChange() {
		this.$nextTick(()=>{
		  document.querySelectorAll('.addEdit-block .upload .el-upload-list--picture-card .el-upload-list__item').forEach(el=>{
			el.style.width = this.addEditForm.uploadHeight
			el.style.height = this.addEditForm.uploadHeight
			el.style.borderWidth = this.addEditForm.uploadBorderWidth
			el.style.borderStyle = this.addEditForm.uploadBorderStyle
			el.style.borderColor = this.addEditForm.uploadBorderColor
			el.style.borderRadius = this.addEditForm.uploadBorderRadius
			el.style.backgroundColor = this.addEditForm.uploadBgColor
		  })
	  })
	},
  }
};
</script>
<style lang="scss">
.editor{
  height: 500px;
  
  & /deep/ .ql-container {
	  height: 310px;
  }
}
.amap-wrapper {
  width: 100%;
  height: 500px;
}
.search-box {
  position: absolute;
}
.addEdit-block {
	margin: -10px;
}
.detail-form-content {
	padding: 12px;
}
.btn .el-button {
  padding: 0;
}
</style>

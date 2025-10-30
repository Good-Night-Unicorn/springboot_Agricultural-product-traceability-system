<template>
	<div class="addEdit-block">
		<el-form
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="180px"
		>
			<template >
				<el-form-item class="input" v-if="type!='info'"  label="溯源码" prop="suyuanma" >
					<el-input v-model="ruleForm.suyuanma" placeholder="溯源码" clearable  :readonly="ro.suyuanma"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="溯源码" prop="suyuanma" >
					<el-input v-model="ruleForm.suyuanma" placeholder="溯源码" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="产品名称" prop="chanpinmingcheng" >
					<el-input v-model="ruleForm.chanpinmingcheng" placeholder="产品名称" clearable  :readonly="ro.chanpinmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="产品名称" prop="chanpinmingcheng" >
					<el-input v-model="ruleForm.chanpinmingcheng" placeholder="产品名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="产品品种" prop="chanpinpinzhong" >
					<el-input v-model="ruleForm.chanpinpinzhong" placeholder="产品品种" clearable  :readonly="ro.chanpinpinzhong"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="产品品种" prop="chanpinpinzhong" >
					<el-input v-model="ruleForm.chanpinpinzhong" placeholder="产品品种" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="经销商名" prop="jingxiaoshangming" >
					<el-input v-model="ruleForm.jingxiaoshangming" placeholder="经销商名" clearable  :readonly="ro.jingxiaoshangming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="经销商名" prop="jingxiaoshangming" >
					<el-input v-model="ruleForm.jingxiaoshangming" placeholder="经销商名" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.tupian" label="图片" prop="tupian" >
					<file-upload
						tip="点击上传图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.tupian?ruleForm.tupian:''"
						@change="tupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.tupian" label="图片" prop="tupian" >
					<img v-if="ruleForm.tupian.substring(0,4)=='http'&&ruleForm.tupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian" width="100" height="100">
					<img v-else-if="ruleForm.tupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.tupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.tupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="加工企业" prop="jiagongqiye" >
					<el-input v-model="ruleForm.jiagongqiye" placeholder="加工企业" clearable  :readonly="ro.jiagongqiye"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="加工企业" prop="jiagongqiye" >
					<el-input v-model="ruleForm.jiagongqiye" placeholder="加工企业" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="生产日期" prop="shengchanriqi" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.shengchanriqi" 
						type="date"
						:readonly="ro.shengchanriqi"
						placeholder="生产日期"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.shengchanriqi" label="生产日期" prop="shengchanriqi" >
					<el-input v-model="ruleForm.shengchanriqi" placeholder="生产日期" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="经销商号" prop="jingxiaoshanghao" >
					<el-input v-model="ruleForm.jingxiaoshanghao" placeholder="经销商号" clearable  :readonly="ro.jingxiaoshanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="经销商号" prop="jingxiaoshanghao" >
					<el-input v-model="ruleForm.jingxiaoshanghao" placeholder="经销商号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="价格" prop="jiage" >
					<el-input v-model.number="ruleForm.jiage" placeholder="价格" clearable  :readonly="ro.jiage"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="价格" prop="jiage" >
					<el-input v-model="ruleForm.jiage" placeholder="价格" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="购买数量" prop="shuliang" >
					<el-input v-model.number="ruleForm.shuliang" placeholder="购买数量" clearable  :readonly="ro.shuliang"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="购买数量" prop="shuliang" >
					<el-input v-model="ruleForm.shuliang" placeholder="购买数量" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="合计" prop="heji" >
					<el-input v-model="heji" placeholder="合计" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.heji" label="合计" prop="heji" >
					<el-input v-model="ruleForm.heji" placeholder="合计" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="账号" prop="zhanghao" >
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" clearable  :readonly="ro.zhanghao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="账号" prop="zhanghao" >
					<el-input v-model="ruleForm.zhanghao" placeholder="账号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="姓名" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="姓名" clearable  :readonly="ro.xingming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="姓名" prop="xingming" >
					<el-input v-model="ruleForm.xingming" placeholder="姓名" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="登记时间" prop="dengjishijian" >
					<el-date-picker
						value-format="yyyy-MM-dd HH:mm:ss"
						v-model="ruleForm.dengjishijian" 
						type="datetime"
						:readonly="ro.dengjishijian"
						placeholder="登记时间"
					></el-date-picker>
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.dengjishijian" label="登记时间" prop="dengjishijian" >
					<el-input v-model="ruleForm.dengjishijian" placeholder="登记时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="select" v-if="type!='info'"  label="状态" prop="zhuangtai" >
					<el-select :disabled="ro.zhuangtai" v-model="ruleForm.zhuangtai" placeholder="请选择状态" >
						<el-option
							v-for="(item,index) in zhuangtaiOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item v-else class="input" label="状态" prop="zhuangtai" >
					<el-input v-model="ruleForm.zhuangtai"
						placeholder="状态" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item class="btn">
				<el-button class="btn3"  v-if="type!='info'" type="success" @click="onSubmit">
					<span class="icon iconfont icon-xihuan"></span>
					确定
				</el-button>
				<el-button class="btn4" v-if="type!='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					取消
				</el-button>
				<el-button class="btn5" v-if="type=='info'" type="success" @click="back()">
					<span class="icon iconfont icon-xihuan"></span>
					返回
				</el-button>
			</el-form-item>
		</el-form>
    

	</div>
</template>
<script>
	import { 
		isIntNumer,
	} from "@/utils/validate";
	export default {
		data() {
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
				id: '',
				type: '',
			
			
				ro:{
					suyuanma : false,
					chanpinmingcheng : false,
					chanpinpinzhong : false,
					jingxiaoshangming : false,
					tupian : false,
					jiagongqiye : false,
					shengchanriqi : false,
					jingxiaoshanghao : false,
					jiage : false,
					shuliang : false,
					heji : false,
					zhanghao : false,
					xingming : false,
					dengjishijian : false,
					zhuangtai : false,
					ispay : false,
				},
			
				ruleForm: {
					suyuanma: '',
					chanpinmingcheng: '',
					chanpinpinzhong: '',
					jingxiaoshangming: '',
					tupian: '',
					jiagongqiye: '',
					shengchanriqi: '',
					jingxiaoshanghao: '',
					jiage: '',
					shuliang: '',
					heji: '',
					zhanghao: '',
					xingming: '',
					dengjishijian: '',
					zhuangtai: '待发货',
				},
				zhuangtaiOptions: [],

				rules: {
					suyuanma: [
					],
					chanpinmingcheng: [
					],
					chanpinpinzhong: [
						{ required: true, message: '产品品种不能为空', trigger: 'blur' },
					],
					jingxiaoshangming: [
					],
					tupian: [
					],
					jiagongqiye: [
						{ required: true, message: '加工企业不能为空', trigger: 'blur' },
					],
					shengchanriqi: [
						{ required: true, message: '生产日期不能为空', trigger: 'blur' },
					],
					jingxiaoshanghao: [
					],
					jiage: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					shuliang: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					heji: [
						{ validator: validateIntNumber, trigger: 'blur' },
					],
					zhanghao: [
					],
					xingming: [
					],
					dengjishijian: [
					],
					zhuangtai: [
						{ required: true, message: '状态不能为空', trigger: 'blur' },
					],
					ispay: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {


			heji:{
				get: function () {
					return 1*this.ruleForm.jiage*this.ruleForm.shuliang
				}
			},

		},
		components: {
		},
		created() {
			this.ruleForm.dengjishijian = this.getCurDateTime()
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
				if(this.type=='info'||this.type=='else'||this.type=='msg'){
					this.info(id);
				}else if(this.type=='logistics'){
					for(let x in this.ro) {
						this.ro[x] = true
					}
					this.logistics=false;
					this.info(id);
				}else if(this.type=='cross'){
					var obj = this.$storage.getObj('crossObj');
					for (var o in obj){
						if(o=='suyuanma'){
							this.ruleForm.suyuanma = obj[o];
							this.ro.suyuanma = true;
							continue;
						}
						if(o=='chanpinmingcheng'){
							this.ruleForm.chanpinmingcheng = obj[o];
							this.ro.chanpinmingcheng = true;
							continue;
						}
						if(o=='chanpinpinzhong'){
							this.ruleForm.chanpinpinzhong = obj[o];
							this.ro.chanpinpinzhong = true;
							continue;
						}
						if(o=='jingxiaoshangming'){
							this.ruleForm.jingxiaoshangming = obj[o];
							this.ro.jingxiaoshangming = true;
							continue;
						}
						if(o=='tupian'){
							this.ruleForm.tupian = obj[o];
							this.ro.tupian = true;
							continue;
						}
						if(o=='jiagongqiye'){
							this.ruleForm.jiagongqiye = obj[o];
							this.ro.jiagongqiye = true;
							continue;
						}
						if(o=='shengchanriqi'){
							this.ruleForm.shengchanriqi = obj[o];
							this.ro.shengchanriqi = true;
							continue;
						}
						if(o=='jingxiaoshanghao'){
							this.ruleForm.jingxiaoshanghao = obj[o];
							this.ro.jingxiaoshanghao = true;
							continue;
						}
						if(o=='jiage'){
							this.ruleForm.jiage = obj[o];
							this.ro.jiage = true;
							continue;
						}
						if(o=='shuliang'){
							this.ruleForm.shuliang = obj[o];
							this.ro.shuliang = true;
							continue;
						}
						if(o=='heji'){
							this.ruleForm.heji = obj[o];
							this.ro.heji = true;
							continue;
						}
						if(o=='zhanghao'){
							this.ruleForm.zhanghao = obj[o];
							this.ro.zhanghao = true;
							continue;
						}
						if(o=='xingming'){
							this.ruleForm.xingming = obj[o];
							this.ro.xingming = true;
							continue;
						}
						if(o=='dengjishijian'){
							this.ruleForm.dengjishijian = obj[o];
							this.ro.dengjishijian = true;
							continue;
						}
						if(o=='zhuangtai'){
							this.ruleForm.zhuangtai = obj[o];
							this.ro.zhuangtai = true;
							continue;
						}
					}
					this.ruleForm.shuliang = 0
					this.ro.shuliang = false;
					this.ruleForm.zhuangtai = '待发货'; 				}
				// 获取用户信息
				this.$http({
					url: `${this.$storage.get('sessionTable')}/session`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						var json = data.data;
						if(((json.zhanghao!=''&&json.zhanghao) || json.zhanghao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.zhanghao = json.zhanghao
							this.ro.zhanghao = true;
						}
						if(((json.xingming!=''&&json.xingming) || json.xingming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.xingming = json.xingming
							this.ro.xingming = true;
						}
						if(this.$storage.get("role")!="管理员") {
							this.ro.zhuangtai = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
				this.zhuangtaiOptions = "已发货,待发货".split(',')
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `dingdanxinxi/info/${id}`,
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
			async onSubmit() {
					this.ruleForm.ispay = '未支付'
					this.ruleForm.heji = this.heji
					if(this.ruleForm.tupian!=null) {
						this.ruleForm.tupian = this.ruleForm.tupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
					var table = this.$storage.getObj('crossTable');
					if(objcross!=null) {
						if(!this.ruleForm.shuliang){
							this.$message.error("购买数量不能为空");
							return
						}
						objcross.shuliang = objcross.shuliang - this.ruleForm.shuliang
						if(objcross.shuliang<0){
							this.$message.error("购买数量不足");
							return
						}
											}
					if(!this.ruleForm.id) {
						delete this.ruleForm.userid
					}
					await this.$refs["ruleForm"].validate(async valid => {
						if (valid) {
							if(this.type=='cross'){
								var statusColumnName = this.$storage.get('statusColumnName');
								var statusColumnValue = this.$storage.get('statusColumnValue');
								if(statusColumnName!='') {
									var obj = this.$storage.getObj('crossObj');
									if(statusColumnName && !statusColumnName.startsWith("[")) {
										for (var o in obj){
											if(o==statusColumnName){
												obj[o] = statusColumnValue;
											}
										}
										var table = this.$storage.get('crossTable');
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: obj
										}).then(({ data }) => {});
										await this.$http({
											url: `${table}/update`,
											method: "post",
											data: objcross
										}).then(({ data }) => {});
									}
								}
							}
							
							await this.$http({
								url: `dingdanxinxi/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											if(this.isAuth('dingdanxinxi','支付')&&this.type=='cross') {
												this.$confirm('是否跳转支付？').then(_ => {
													this.parent.showFlag = true;
													this.parent.addOrUpdateFlag = false;
													this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
													this.$router.push('/dingdanxinxi')
												}).catch(_ => {
													this.parent.showFlag = true;
													this.parent.addOrUpdateFlag = false;
													this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
													this.parent.search();
													this.parent.contentStyleChange();
												});
											}else {
												this.parent.showFlag = true;
												this.parent.addOrUpdateFlag = false;
												this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
												this.parent.search();
												this.parent.contentStyleChange();
											}
											
										}
									});
									var table = this.$storage.get('crossTable');
									await this.$http({
										url: `${table}/update`,
										method: "post",
										data: objcross
									}).then(({ data }) => {});
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
				this.parent.dingdanxinxiCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			tupianUploadChange(fileUrls) {
				this.ruleForm.tupian = fileUrls;
			},
		}
	};
</script>
<style lang="scss" scoped>
	.addEdit-block {
		padding: 0px 30px 30px;
		margin: 0 auto;
		background: none;
		width: calc(100% - 0px);
		font-size: 15px;
	}
	.add-update-preview {
		border-radius: 10px;
		padding: 40px 25% 40px 15%;
		background: #fff;
		width: 100%;
		border-color: #eee;
		border-width: 0px 0 0;
		border-style: solid;
	}
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}
	
	.search-box {
		position: absolute;
	}
	
	.el-date-editor.el-input {
		width: auto;
	}
	.add-update-preview /deep/ .el-form-item {
		border: 0px solid #eee;
		padding: 0;
		margin: 0 0 26px 0;
		display: inline-block;
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-form-item /deep/ .el-form-item__label {
		padding: 0 10px 0 0;
		color: #666;
		font-weight: 600;
		width: 180px;
		font-size: 16px;
		line-height: 40px;
		text-align: right;
	}
	
	.add-update-preview .el-form-item /deep/ .el-form-item__content {
		margin-left: 180px;
	}
	.add-update-preview .el-form-item span.text {
		padding: 10px 10px;
		color: #333;
		background: #fff;
		font-weight: 500;
		display: inline-block;
		font-size: 16px;
		line-height: 1.5;
		min-width: 100%;
	}
	
	.add-update-preview .el-input {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-input /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input /deep/ .el-input__inner[readonly="readonly"] {
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number {
		text-align: left;
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-input-number /deep/ .el-input__inner {
		text-align: left;
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		width: 100%;
		font-size: 16px;
		min-width: 50%;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .is-disabled .el-input__inner {
		text-align: left;
		border: 0px solid #ccc;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 12px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__decrease {
		display: none;
	}
	.add-update-preview .el-input-number /deep/ .el-input-number__increase {
		display: none;
	}
	.add-update-preview .el-select {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-select /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 10px;
		color: #666;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-select /deep/ .is-disabled .el-input__inner {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 10px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 34px;
	}
	.add-update-preview .el-date-editor {
		width: 100%;
		text-align: left;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .el-date-editor /deep/ .el-input__inner[readonly="readonly"] {
		border: 0;
		cursor: not-allowed;
		border-radius: 0px;
		padding: 0 10px 0 30px;
		color: #666;
		background: none;
		width: 100%;
		font-size: 16px;
		height: 40px;
	}
	.add-update-preview .viewBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .viewBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .downBtn {
		border: 0px solid #ccc;
		cursor: pointer;
		border-radius: 0px;
		padding: 0 15px;
		margin: 0 20px 0 0;
		color: #666;
		background: #fff;
		width: auto;
		font-size: 15px;
		line-height: 34px;
		height: 34px;
		.iconfont {
			margin: 0 2px;
			color: #666;
			font-size: 16px;
			height: 34px;
		}
	}
	.add-update-preview .downBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview .unBtn {
		border: 0;
		cursor: not-allowed;
		border-radius: 4px;
		padding: 0 0px;
		margin: 0 20px 0 0;
		outline: none;
		color: #999;
		background: none;
		width: auto;
		font-size: 16px;
		line-height: 40px;
		height: 40px;
		.iconfont {
			margin: 0 2px;
			color: #fff;
			display: none;
			font-size: 14px;
			height: 34px;
		}
	}
	.add-update-preview .unBtn:hover {
		opacity: 0.8;
	}
	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}
	
	.add-update-preview /deep/ .upload .upload-img {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	
	.add-update-preview /deep/ .el-upload .el-icon-plus {
		border: 1px solid #e8e8e8;
		cursor: pointer;
		border-radius: 0px;
		color: #666;
		background: #fff;
		width: 90px;
		font-size: 24px;
		line-height: 60px;
		text-align: center;
		height: 60px;
	}
	.add-update-preview /deep/ .el-upload__tip {
		color: #666;
		font-size: 15px;
	}
	
	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
		border: 1px solid #e8e8e8;
		border-radius: 0px;
		padding: 12px;
		color: #666;
		background: #fff;
		width: 100%;
		font-size: 14px;
		min-width: 400px;
		height: 120px;
	}
	.add-update-preview .el-textarea /deep/ .el-textarea__inner[readonly="readonly"] {
				border: 0;
				cursor: not-allowed;
				border-radius: 0px;
				padding: 12px;
				color: #666;
				background: none;
				width: 100%;
				font-size: 14px;
				min-width: 400px;
				height: auto;
			}
	.add-update-preview .el-form-item.btn {
		padding: 0;
		margin: 20px 0 0;
		.btn1 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ff5f32;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn1:hover {
			opacity: 0.8;
		}
		.btn2 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #ffb64f;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 34px;
			}
		}
		.btn2:hover {
			opacity: 0.8;
		}
		.btn3 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #fcbb78;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn3:hover {
			opacity: 0.8;
		}
		.btn4 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #de7153;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn4:hover {
			opacity: 0.8;
		}
		.btn5 {
			border: 0px solid #ccc;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 10px;
			margin: 0 10px 0 0;
			color: #fff;
			background: #db6f3d;
			width: auto;
			font-size: 16px;
			min-width: 110px;
			height: 40px;
			.iconfont {
				margin: 0 2px;
				color: #fff;
				display: none;
				font-size: 14px;
				height: 40px;
			}
		}
		.btn5:hover {
			opacity: 0.8;
		}
	}
</style>

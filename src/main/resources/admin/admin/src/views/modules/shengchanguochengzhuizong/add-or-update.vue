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
				<el-form-item class="input" v-if="type!='info'"  label="农产品名称" prop="nongchanpinmingcheng" >
					<el-input v-model="ruleForm.nongchanpinmingcheng" placeholder="农产品名称" clearable  :readonly="ro.nongchanpinmingcheng"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="农产品名称" prop="nongchanpinmingcheng" >
					<el-input v-model="ruleForm.nongchanpinmingcheng" placeholder="农产品名称" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="农产品品种" prop="nongchanpinpinzhong" >
					<el-input v-model="ruleForm.nongchanpinpinzhong" placeholder="农产品品种" clearable  :readonly="ro.nongchanpinpinzhong"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="农产品品种" prop="nongchanpinpinzhong" >
					<el-input v-model="ruleForm.nongchanpinpinzhong" placeholder="农产品品种" readonly></el-input>
				</el-form-item>
				<el-form-item class="upload" v-if="type!='info' && !ro.chanpintupian" label="产品图片" prop="chanpintupian" >
					<file-upload
						tip="点击上传产品图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.chanpintupian?ruleForm.chanpintupian:''"
						@change="chanpintupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item class="upload" v-else-if="ruleForm.chanpintupian" label="产品图片" prop="chanpintupian" >
					<img v-if="ruleForm.chanpintupian.substring(0,4)=='http'&&ruleForm.chanpintupian.split(',w').length>1" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.chanpintupian" width="100" height="100">
					<img v-else-if="ruleForm.chanpintupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.chanpintupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.chanpintupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="土壤酸碱度" prop="turangsuanjiandu" >
					<el-input v-model="ruleForm.turangsuanjiandu" placeholder="土壤酸碱度" clearable  :readonly="ro.turangsuanjiandu"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="土壤酸碱度" prop="turangsuanjiandu" >
					<el-input v-model="ruleForm.turangsuanjiandu" placeholder="土壤酸碱度" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="土壤肥力值" prop="turangfeilizhi" >
					<el-input v-model="ruleForm.turangfeilizhi" placeholder="土壤肥力值" clearable  :readonly="ro.turangfeilizhi"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="土壤肥力值" prop="turangfeilizhi" >
					<el-input v-model="ruleForm.turangfeilizhi" placeholder="土壤肥力值" readonly></el-input>
				</el-form-item>
				<el-form-item class="date" v-if="type!='info'" label="采摘时间" prop="caizhaishijian" >
					<el-date-picker
						format="yyyy 年 MM 月 dd 日"
						value-format="yyyy-MM-dd"
						v-model="ruleForm.caizhaishijian" 
						type="date"
						:readonly="ro.caizhaishijian"
						placeholder="采摘时间"
					></el-date-picker> 
				</el-form-item>
				<el-form-item class="input" v-else-if="ruleForm.caizhaishijian" label="采摘时间" prop="caizhaishijian" >
					<el-input v-model="ruleForm.caizhaishijian" placeholder="采摘时间" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="生产者号" prop="shengchanzhehao" >
					<el-input v-model="ruleForm.shengchanzhehao" placeholder="生产者号" clearable  :readonly="ro.shengchanzhehao"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="生产者号" prop="shengchanzhehao" >
					<el-input v-model="ruleForm.shengchanzhehao" placeholder="生产者号" readonly></el-input>
				</el-form-item>
				<el-form-item class="input" v-if="type!='info'"  label="生产者名" prop="shengchanzheming" >
					<el-input v-model="ruleForm.shengchanzheming" placeholder="生产者名" clearable  :readonly="ro.shengchanzheming"></el-input>
				</el-form-item>
				<el-form-item v-else class="input" label="生产者名" prop="shengchanzheming" >
					<el-input v-model="ruleForm.shengchanzheming" placeholder="生产者名" readonly></el-input>
				</el-form-item>
			</template>
			<el-form-item v-if="type!='info'"  label="灌溉" prop="guangai" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.guangai" 
					class="editor"
					myQuillEditor="guangai"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.guangai" label="灌溉" prop="guangai" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.guangai"></span>
			</el-form-item>
			<el-form-item v-if="type!='info'"  label="播种记录" prop="bozhongjilu" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.bozhongjilu" 
					class="editor"
					myQuillEditor="bozhongjilu"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.bozhongjilu" label="播种记录" prop="bozhongjilu" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.bozhongjilu"></span>
			</el-form-item>
			<el-form-item v-if="type!='info'"  label="施肥记录" prop="shifeijilu" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.shifeijilu" 
					class="editor"
					myQuillEditor="shifeijilu"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.shifeijilu" label="施肥记录" prop="shifeijilu" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.shifeijilu"></span>
			</el-form-item>
			<el-form-item v-if="type!='info'"  label="施药记录" prop="shiyaojilu" >
				<editor 
					style="min-width: 200px; max-width: 600px;"
					v-model="ruleForm.shiyaojilu" 
					class="editor"
					myQuillEditor="shiyaojilu"
					action="file/upload">
				</editor>
			</el-form-item>
			<el-form-item v-else-if="ruleForm.shiyaojilu" label="施药记录" prop="shiyaojilu" >
				<span class="text ql-snow ql-editor" v-html="ruleForm.shiyaojilu"></span>
			</el-form-item>
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
	export default {
		data() {
			return {
				id: '',
				type: '',
			
			
				ro:{
					suyuanma : false,
					nongchanpinmingcheng : false,
					nongchanpinpinzhong : false,
					chanpintupian : false,
					turangsuanjiandu : false,
					turangfeilizhi : false,
					guangai : false,
					bozhongjilu : false,
					shifeijilu : false,
					shiyaojilu : false,
					caizhaishijian : false,
					shengchanzhehao : false,
					shengchanzheming : false,
				},
			
				ruleForm: {
					suyuanma: '',
					nongchanpinmingcheng: '',
					nongchanpinpinzhong: '',
					chanpintupian: '',
					turangsuanjiandu: '',
					turangfeilizhi: '',
					guangai: '',
					bozhongjilu: '',
					shifeijilu: '',
					shiyaojilu: '',
					caizhaishijian: '',
					shengchanzhehao: '',
					shengchanzheming: '',
				},

				rules: {
					suyuanma: [
					],
					nongchanpinmingcheng: [
					],
					nongchanpinpinzhong: [
						{ required: true, message: '农产品品种不能为空', trigger: 'blur' },
					],
					chanpintupian: [
					],
					turangsuanjiandu: [
						{ required: true, message: '土壤酸碱度不能为空', trigger: 'blur' },
					],
					turangfeilizhi: [
						{ required: true, message: '土壤肥力值不能为空', trigger: 'blur' },
					],
					guangai: [
						{ required: true, message: '灌溉不能为空', trigger: 'blur' },
					],
					bozhongjilu: [
					],
					shifeijilu: [
					],
					shiyaojilu: [
					],
					caizhaishijian: [
					],
					shengchanzhehao: [
					],
					shengchanzheming: [
					],
				},
			};
		},
		props: ["parent"],
		computed: {



		},
		components: {
		},
		created() {
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
						if(o=='nongchanpinmingcheng'){
							this.ruleForm.nongchanpinmingcheng = obj[o];
							this.ro.nongchanpinmingcheng = true;
							continue;
						}
						if(o=='nongchanpinpinzhong'){
							this.ruleForm.nongchanpinpinzhong = obj[o];
							this.ro.nongchanpinpinzhong = true;
							continue;
						}
						if(o=='chanpintupian'){
							this.ruleForm.chanpintupian = obj[o];
							this.ro.chanpintupian = true;
							continue;
						}
						if(o=='turangsuanjiandu'){
							this.ruleForm.turangsuanjiandu = obj[o];
							this.ro.turangsuanjiandu = true;
							continue;
						}
						if(o=='turangfeilizhi'){
							this.ruleForm.turangfeilizhi = obj[o];
							this.ro.turangfeilizhi = true;
							continue;
						}
						if(o=='guangai'){
							this.ruleForm.guangai = obj[o];
							this.ro.guangai = true;
							continue;
						}
						if(o=='bozhongjilu'){
							this.ruleForm.bozhongjilu = obj[o];
							this.ro.bozhongjilu = true;
							continue;
						}
						if(o=='shifeijilu'){
							this.ruleForm.shifeijilu = obj[o];
							this.ro.shifeijilu = true;
							continue;
						}
						if(o=='shiyaojilu'){
							this.ruleForm.shiyaojilu = obj[o];
							this.ro.shiyaojilu = true;
							continue;
						}
						if(o=='caizhaishijian'){
							this.ruleForm.caizhaishijian = obj[o];
							this.ro.caizhaishijian = true;
							continue;
						}
						if(o=='shengchanzhehao'){
							this.ruleForm.shengchanzhehao = obj[o];
							this.ro.shengchanzhehao = true;
							continue;
						}
						if(o=='shengchanzheming'){
							this.ruleForm.shengchanzheming = obj[o];
							this.ro.shengchanzheming = true;
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
						if(((json.shengchanzhehao!=''&&json.shengchanzhehao) || json.shengchanzhehao==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.shengchanzhehao = json.shengchanzhehao
							this.ro.shengchanzhehao = true;
						}
						if(((json.shengchanzheming!=''&&json.shengchanzheming) || json.shengchanzheming==0) && this.$storage.get("role")!="管理员"){
							this.ruleForm.shengchanzheming = json.shengchanzheming
							this.ro.shengchanzheming = true;
						}
					} else {
						this.$message.error(data.msg);
					}
				});
			
			},
			// 多级联动参数

			info(id) {
				this.$http({
					url: `shengchanguochengzhuizong/info/${id}`,
					method: "get"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.ruleForm = data.data;
						//解决前台上传图片后台不显示的问题
						let reg=new RegExp('../../../upload','g')//g代表全部
						this.ruleForm.guangai = this.ruleForm.guangai.replace(reg,'../../../springbootu4nad998/upload');
						this.ruleForm.bozhongjilu = this.ruleForm.bozhongjilu.replace(reg,'../../../springbootu4nad998/upload');
						this.ruleForm.shifeijilu = this.ruleForm.shifeijilu.replace(reg,'../../../springbootu4nad998/upload');
						this.ruleForm.shiyaojilu = this.ruleForm.shiyaojilu.replace(reg,'../../../springbootu4nad998/upload');
					} else {
						this.$message.error(data.msg);
					}
				});
			},

			// 提交
			async onSubmit() {
					if(this.ruleForm.chanpintupian!=null) {
						this.ruleForm.chanpintupian = this.ruleForm.chanpintupian.replace(new RegExp(this.$base.url,"g"),"");
					}
					var objcross = this.$storage.getObj('crossObj');
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
									}
								}
							}
							
							await this.$http({
								url: `shengchanguochengzhuizong/${!this.ruleForm.id ? "save" : "update"}`,
								method: "post",
								data: this.ruleForm
							}).then(async ({ data }) => {
								if (data && data.code === 0) {
									this.$message({
										message: "操作成功",
										type: "success",
										duration: 1500,
										onClose: () => {
											this.parent.showFlag = true;
											this.parent.addOrUpdateFlag = false;
											this.parent.shengchanguochengzhuizongCrossAddOrUpdateFlag = false;
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
				this.parent.shengchanguochengzhuizongCrossAddOrUpdateFlag = false;
				this.parent.contentStyleChange();
			},
			chanpintupianUploadChange(fileUrls) {
				this.ruleForm.chanpintupian = fileUrls;
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

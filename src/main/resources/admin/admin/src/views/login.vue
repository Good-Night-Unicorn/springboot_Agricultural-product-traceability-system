<template>
	<div>
		<div class="login-container">
			<div class="login-swiper3">
				<div class="swiper-container mySwiper3">
					<div class="swiper-wrapper">
						<div class="swiper-slide" v-for="(item,index) in swiperList" :key="item.id">
							<div>
								<el-image :src="item.url" fit="cover"></el-image>
							</div>
						</div>
					</div>
					<!-- Add Pagination -->
					<div class="swiper-pagination"></div>
					<!-- Add Arrows -->
					<div class="swiper-button-next">
						<span class="icon iconfont icon-jiantou18"></span>
					</div>
					<div class="swiper-button-prev">
						<span class="icon iconfont icon-jiantou39"></span>
					</div>
				</div>
			</div>
			<el-form class="login_form animate__animated animate__slideInDown">
				<div class="login_form2">
					<div class="title-container">基于SpringBoot的农产品溯源系统</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							账号：
						</div>
						<input placeholder="请输入账号：" name="username" type="text" v-model="rulesForm.username">
					</div>
					<div v-if="loginType==1" class="list-item">
						<div class="lable">
							密码：
						</div>
						<div class="password-box">
							<input placeholder="请输入密码：" name="password" :type="showPassword?'text':'password'" v-model="rulesForm.password">
							<span class="icon iconfont" :class="showPassword?'icon-liulan13':'icon-liulan17'" @click="showPassword=!showPassword"></span>
						</div>
					</div>

					<div class="list-item select" v-if="roles.length>1">
						<div class="lable">
							角色：
						</div>
						<el-select v-model="rulesForm.role" placeholder="请选择角色：">
							<el-option v-if="loginType==1||(loginType==2&&item.roleName!='管理员')" v-for="item in roles" :key="item.roleName" :label="item.roleName" :value="item.roleName" />
						</el-select>
					</div>

		
					<div class="login-btn">
						<div class="login-btn1">
							<el-button v-if="loginType==1" type="primary" @click="login()" class="loginInBt">登录</el-button>
						</div>
						<div class="login-btn2">
							<el-button type="primary" @click="register('xiaofeizhe')" class="register">
								注册消费者							</el-button>
							<el-button type="primary" @click="register('jingxiaoshang')" class="register">
								注册经销商							</el-button>
							<el-button type="primary" @click="register('jianguanzhe')" class="register">
								注册监管者							</el-button>
							<el-button type="primary" @click="register('shengchanzhe')" class="register">
								注册生产者							</el-button>
						</div>
						<div class="login-btn3">
						</div>
					</div>
				</div>
			</el-form>
		</div>
	</div>
</template>
<script>
	import 'animate.css'
	import menu from "@/utils/menu";
	import Swiper from "swiper";
	export default {
		data() {
			return {
				verifyCheck2: false,
				flag: false,
				baseUrl:this.$base.url,
				loginType: 1,
				rulesForm: {
					username: "",
					password: "",
					role: "",
				},
				menus: [],
				roles: [],
				tableName: "",
				showPassword: false,
				swiperList: [{"name":"01.jpg","uid":1728872474838,"url":"http://codegen.caihongy.cn/20241014/c185ab31094b425ba8ccaff35ca5e98b.jpg","status":"success"},{"name":"02.jpg","uid":1728872483409,"url":"http://codegen.caihongy.cn/20241014/c42ee4a5c8e94213bdd90745af97e15c.jpg","status":"success"},{"name":"03.jpg","uid":1728872489084,"url":"http://codegen.caihongy.cn/20241014/17534ced15cb47319cd779d24aa2a775.jpg","status":"success"}],
			};
		},
		mounted() {
			let menus = menu.list();
			this.menus = menus;

			for (let i = 0; i < this.menus.length; i++) {
				if (this.menus[i].hasBackLogin=='是') {
					this.roles.push(this.menus[i])
				}
			}

			setTimeout(()=>{
				new Swiper(".mySwiper3", {"navigation":{"nextEl":".swiper-button-next","prevEl":".swiper-button-prev"},"pagination":{"el":".swiper-pagination","clickable":true},"autoplay":{"delay":3000,"disableOnInteraction":false},"effect":"fade"})
			}, 500)
		},
		created() {

		},
		destroyed() {
		},
		components: {
		},
		methods: {

			//注册
			register(tableName){
				this.$storage.set("loginTable", tableName);
				this.$router.push({path:'/register',query:{pageFlag:'register'}})
			},
			// 登陆
			login() {

				if (!this.rulesForm.username) {
					this.$message.error("请输入用户名");
					return;
				}
				if (!this.rulesForm.password) {
					this.$message.error("请输入密码");
					return;
				}
				if(this.roles.length>1) {
					if (!this.rulesForm.role) {
						this.$message.error("请选择角色");
						return;
					}

					let menus = this.menus;
					for (let i = 0; i < menus.length; i++) {
						if (menus[i].roleName == this.rulesForm.role) {
							this.tableName = menus[i].tableName;
						}
					}
				} else {
					this.tableName = this.roles[0].tableName;
					this.rulesForm.role = this.roles[0].roleName;
				}
		
				this.loginPost()
			},
			loginPost() {
				this.$http({
					url: `${this.tableName}/login?username=${this.rulesForm.username}&password=${this.rulesForm.password}`,
					method: "post"
				}).then(({ data }) => {
					if (data && data.code === 0) {
						this.$storage.set("Token", data.token);
						this.$storage.set("role", this.rulesForm.role);
						this.$storage.set("sessionTable", this.tableName);
						this.$storage.set("adminName", this.rulesForm.username);
						this.$router.replace({ path: "/" });
					} else {
						this.$message.error(data.msg);
					}
				});
			},
		}
	}
</script>

<style lang="scss" scoped>
.login-container {
	min-height: 100vh;
	position: relative;
	background-repeat: no-repeat;
	background-position: center center;
	background-size: cover;
	background-repeat: no-repeat;
	background-size: cover;
	background: url(http://codegen.caihongy.cn/20241012/2cf64ce479c04083a028aeeade009ddc.jpg);
	display: flex;
	width: 100%;
	min-height: 100vh;
	justify-content: center;
	align-items: center;
	background-position: center bottom;

	.login-swiper3 {
		margin: 0 auto;
		z-index: 999;
		top: 0;
		left: 0;
		width: 100vw;
		position: fixed;
		height: 100vh;
		.swiper-container {
			.swiper-slide {
				div {
					width: 100%;
					height: 100vh;
					.el-image {
						object-fit: cover;
						width: 100%;
						height: 100vh;
					}
				}
			}
			.swiper-pagination{
				left: 0;
				bottom: 10px;
				width: 100%;
				/deep/ span.swiper-pagination-bullet {
					border-radius: 100%;
					margin: 0 4px;
					background: #000;
					display: inline-block;
					width: 8px;
					opacity: .2;
					height: 8px;
				}
				/deep/ span.swiper-pagination-bullet:hover {
					background: #fff;
					opacity: 1;
				}
				/deep/ span.swiper-pagination-bullet.swiper-pagination-bullet-active {
					background: #fff;
					opacity: 1;
				}
			}
			.swiper-button-next {
				cursor: pointer;
				border-radius: 0;
				margin: -12px 0 0;
				z-index: 9999;
				top: 50%;
				background: none;
				position: absolute;
				.iconfont {
					color: #fff;
					width: 24px;
					font-size: 24px;
					height: 24px;
				}
			}
			.swiper-button-prev {
				cursor: pointer;
				margin: -12px 0 0;
				z-index: 9999;
				top: 50%;
				background: none;
				position: absolute;
				.iconfont {
					color: #fff;
					width: 24px;
					font-size: 24px;
					height: 24px;
				}
			}
			
			.swiper-button-prev:after {
				display:none;
			}
			.swiper-button-next:after {
				display:none;
			}
		}
	}
	.login_form {
		border-radius: 0px;
		padding: 40px 80px 0px 460px;
		margin: 0;
		z-index: 1000;
		flex-direction: column;
		background: url(http://codegen.caihongy.cn/20241012/eaf0063a857e492b971e6c163c5883e4.png) no-repeat 50px 80px,url(http://codegen.caihongy.cn/20241012/13b7da1f594a4700a294d984c4f318a9.png) no-repeat center top / 100% 100%;
		display: flex;
		width: 880px;
		align-items: center;
		position: relative;
		flex-wrap: wrap;
		height: auto;
		.login_form2 {
			width: 100%;
		}
		.title-container {
			padding: 0 0px;
			margin: 0 0 20px -140px;
			color: #fff;
			background: noner;
			font-weight: 600;
			width: calc(100% + 140px);
			font-size: 22px;
			line-height: 40px;
			text-align: center;
		}
		.list-item {
			padding: 0;
			margin: 0 0 26px;
			display: flex;
			width: calc(100% - 0px);
			align-items: center;
			position: relative;
			flex-wrap: wrap;
			.lable {
				padding: 0 20px 0 0;
				color: #fff;
				left: -140px;
				background: rgba(0, 0, 0, .5);
				width: 140px;
				font-size: 16px;
				line-height: 44px;
				position: absolute;
				text-align: right;
			}
			input {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				color: #999;
				background: rgba(0, 0, 0, .5);
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			input:focus {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				outline: none;
				color: #999;
				background: rgba(0, 0, 0, .5);
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			.password-box {
				display: flex;
				width: 100%;
				position: relative;
				align-items: center;
				input {
					border: 0px solid #efeff7;
					border-radius: 0;
					padding: 0 10px;
					color: #999;
					background: rgba(0, 0, 0, .5);
					width: 100%;
					font-size: 14px;
					height: 44px;
				}
				input:focus {
					border: 0px solid #efeff7;
					border-radius: 0;
					padding: 0 10px;
					outline: none;
					color: #999;
					background: rgba(0, 0, 0, .5);
					width: 100%;
					font-size: 14px;
					height: 44px;
				}
				.iconfont {
					cursor: pointer;
					z-index: 1;
					color: #ccc;
					top: 0;
					font-size: 16px;
					line-height: 44px;
					position: absolute;
					right: 12px;
				}
			}
			input::placeholder {
				color: #999;
				font-size: 16px;
			}
			/deep/ .el-select {
				width: 100%;
			}
			/deep/ .el-select .el-input__inner {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				color: #999;
				background: rgba(0, 0, 0, .5);
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			/deep/ .el-select .is-focus .el-input__inner {
				border: 0px solid #efeff7;
				border-radius: 0;
				padding: 0 10px;
				outline: none;
				color: #999;
				background: rgba(0, 0, 0, .5);
				width: 100%;
				font-size: 16px;
				height: 44px;
			}
			/deep/ .el-select .el-input__inner::placeholder{
				color: #999;
				font-size: 16px;
			}
		}
		.login-btn {
			margin: 20px 0 20px -140px;
			display: flex;
			width: calc(100% + 140px);
			justify-content: center;
			align-items: center;
			flex-wrap: wrap;
			.login-btn1 {
				margin: 0;
				width: 100%;
				order: 2;
			}
			.login-btn2 {
				display: flex;
				width: 100%;
				justify-content: center;
				align-items: center;
				flex-wrap: wrap;
				order: 3;
			}
			.login-btn3 {
				width: 100%;
			}
			.loginInBt {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				padding: 0 10px;
				margin: 0 0 10px;
				color: #fff;
				font-weight: 600;
				letter-spacing: 2px;
				font-size: 20px;
				border-radius: 0;
				background: #FF5F32;
				width: 100%;
				min-width: 68px;
				height: 44px;
			}
			.loginInBt:hover {
				opacity: 1;
			}
			.register {
				border: 0px solid rgba(0, 0, 0, 1);
				cursor: pointer;
				border-radius: 0;
				padding: 0 0px;
				margin: 0 10px;
				color: #fff;
				background: none;
				width: auto;
				font-size: 16px;
				height: 44px;
			}
			.register:hover {
				opacity: 1;
			}
			.forget {
				border: 0;
				cursor: pointer;
				border-radius: 0;
				padding: 0;
				margin: 0 10px 10px 0;
				color: #fff;
				background: none;
				width: 100%;
				font-size: 15px;
				text-align: right;
				height: 34px;
			}
			.forget:hover {
				opacity: 1;
			}
		}
	}
}

</style>

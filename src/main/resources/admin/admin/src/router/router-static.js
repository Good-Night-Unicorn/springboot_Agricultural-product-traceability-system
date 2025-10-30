import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
	import jiagonghuanjie from '@/views/modules/jiagonghuanjie/list'
	import nongchanpin from '@/views/modules/nongchanpin/list'
	import shengchanguochengzhuizong from '@/views/modules/shengchanguochengzhuizong/list'
	import jianguanzhe from '@/views/modules/jianguanzhe/list'
	import jingxiaoshang from '@/views/modules/jingxiaoshang/list'
	import shengchanzhe from '@/views/modules/shengchanzhe/list'
	import dingdanxinxi from '@/views/modules/dingdanxinxi/list'
	import nongchanpinjichuxinxi from '@/views/modules/nongchanpinjichuxinxi/list'
	import wuliuyunshu from '@/views/modules/wuliuyunshu/list'
	import shouhuoxinxi from '@/views/modules/shouhuoxinxi/list'
	import zhiliangjiance from '@/views/modules/zhiliangjiance/list'
	import xiaofeizhe from '@/views/modules/xiaofeizhe/list'


//2.配置路由   注意：名字
export const routes = [{
	path: '/',
	name: '系统首页',
	component: Index,
	children: [{
		// 这里不设置值，是把main作为默认页面
		path: '/',
		name: '系统首页',
		component: Home,
		meta: {icon:'', title:'center', affix: true}
	}, {
		path: '/updatePassword',
		name: '修改密码',
		component: UpdatePassword,
		meta: {icon:'', title:'updatePassword'}
	}, {
		path: '/pay',
		name: '支付',
		component: pay,
		meta: {icon:'', title:'pay'}
	}, {
		path: '/center',
		name: '个人信息',
		component: center,
		meta: {icon:'', title:'center'}
	}
	,{
		path: '/jiagonghuanjie',
		name: '加工环节',
		component: jiagonghuanjie
	}
	,{
		path: '/nongchanpin',
		name: '农产品',
		component: nongchanpin
	}
	,{
		path: '/shengchanguochengzhuizong',
		name: '生产过程追踪',
		component: shengchanguochengzhuizong
	}
	,{
		path: '/jianguanzhe',
		name: '监管者',
		component: jianguanzhe
	}
	,{
		path: '/jingxiaoshang',
		name: '经销商',
		component: jingxiaoshang
	}
	,{
		path: '/shengchanzhe',
		name: '生产者',
		component: shengchanzhe
	}
	,{
		path: '/dingdanxinxi',
		name: '订单信息',
		component: dingdanxinxi
	}
	,{
		path: '/nongchanpinjichuxinxi',
		name: '农产品基础信息',
		component: nongchanpinjichuxinxi
	}
	,{
		path: '/wuliuyunshu',
		name: '物流运输',
		component: wuliuyunshu
	}
	,{
		path: '/shouhuoxinxi',
		name: '收货信息',
		component: shouhuoxinxi
	}
	,{
		path: '/zhiliangjiance',
		name: '质量检测',
		component: zhiliangjiance
	}
	,{
		path: '/xiaofeizhe',
		name: '消费者',
		component: xiaofeizhe
	}
	]
	},
	{
		path: '/login',
		name: 'login',
		component: Login,
		meta: {icon:'', title:'login'}
	},
	{
		path: '/register',
		name: 'register',
		component: register,
		meta: {icon:'', title:'register'}
	},
	{
		path: '*',
		component: NotFound
	}
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
	mode: 'hash',
	/*hash模式改为history*/
	routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}
export default router;

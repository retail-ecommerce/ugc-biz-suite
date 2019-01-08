
import ImagePreview from '../../components/ImagePreview'
import { Link } from 'dva/router'
import moment from 'moment'




const menuData = {menuName:"Blog", menuFor: "blog",
  		subItems: [
  
  		],
}

const renderTextCell=(value, record)=>{

	if(!value){
		return '';
	}
	if(value==null){
		return '';
	}
	if(value.length>15){
		return value.substring(0,15)+"...("+value.length+"字)"
	}
	return value
	
}

const renderIdentifier=(value, record, targtObjectType)=>{

	return (<Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>)
	
}

const renderDateCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD');
}
const renderDateTimeCell=(value, record)=>{
	return moment(value).format('YYYY-MM-DD HH:mm');	
}

const renderImageCell=(value, record, title)=>{
	return (<ImagePreview imageTitle={title} imageLocation={value} />)	
}

const renderMoneyCell=(value, record)=>{
	if(!value){
		return '空'
	}
	if(value == null){
		return '空'
	}
	return (`￥${value.toFixed(2)}`)
}

const renderBooleanCell=(value, record)=>{

	return  (value? '是' : '否')

}

const renderReferenceCell=(value, record)=>{

	return (value ? value.displayName : '暂无') 

}

const displayColumns = [
  { title: 'Id', debugtype: 'string', dataIndex: 'id', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Title', debugtype: 'string', dataIndex: 'title', width: '20',render: (text, record)=>renderTextCell(text,record) },
  { title: 'Content', debugtype: 'string_longtext', dataIndex: 'content', width: '10',render: (text, record)=>renderTextCell(text,record) },
  { title: 'User', dataIndex: 'user', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Product', dataIndex: 'product', render: (text, record) => renderReferenceCell(text, record)},
  { title: 'Update Time', dataIndex: 'updateTime', render: (text, record) =>renderDateTimeCell(text,record)  },

]

const fieldLabels = {
  id: 'Id',
  title: 'Title',
  content: 'Content',
  user: 'User',
  product: 'Product',
  updateTime: 'Update Time',

}


const BlogBase={menuData,displayColumns,fieldLabels,displayColumns}
export default BlogBase




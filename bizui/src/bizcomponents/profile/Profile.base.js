import ImagePreview from '../../components/ImagePreview';
import { Link } from 'dva/router';
import moment from 'moment';
import appLocaleName from '../../common/Locale.tool';

const menuData = {
  menuName: 'Profile',
  menuFor: 'profile',
  subItems: [
    {
      name: 'ratingList',
      displayName: 'Rating',
      icon: 'at',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
    },
    {
      name: 'reviewList',
      displayName: 'Review',
      icon: 'rev',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
    },
    {
      name: 'blogList',
      displayName: 'Blog',
      icon: 'blogger',
      readPermission: false,
      createPermission: false,
      deletePermission: false,
      updatePermission: false,
      executionPermission: false,
    },
  ],
};

const renderTextCell = (value, record) => {
  const userContext = null;
  if (!value) {
    return '';
  }
  if (value == null) {
    return '';
  }
  if (value.length > 15) {
    return (
      value.substring(0, 15) + '...(' + value.length + appLocaleName(userContext, 'Chars') + ')'
    );
  }
  return value;
};

const renderIdentifier = (value, record, targtObjectType) => {
  return <Link to={`/${targtObjectType}/${value}/dashboard`}>{value}</Link>;
};

const renderDateCell = (value, record) => {
  return moment(value).format('YYYY-MM-DD');
};
const renderDateTimeCell = (value, record) => {
  return moment(value).format('YYYY-MM-DD HH:mm');
};

const renderImageCell = (value, record, title) => {
  return <ImagePreview imageTitle={title} imageLocation={value} />;
};

const renderMoneyCell = (value, record) => {
  const userContext = null;
  if (!value) {
    return appLocaleName(userContext, 'Empty');
  }
  if (value == null) {
    return appLocaleName(userContext, 'Empty');
  }
  return `${appLocaleName(userContext, 'Currency')}${value.toFixed(2)}`;
};

const renderBooleanCell = (value, record) => {
  const userContext = null;

  return value ? appLocaleName(userContext, 'Yes') : appLocaleName(userContext, 'No');
};

const renderReferenceCell = (value, record) => {
  const userContext = null;
  return value ? value.displayName : appLocaleName(userContext, 'NotAssigned');
};

const displayColumns = [
  {
    title: 'Id',
    debugtype: 'string',
    dataIndex: 'id',
    width: '20',
    render: (text, record) => renderTextCell(text, record, 'profile'),
  },
  {
    title: 'Name',
    debugtype: 'string',
    dataIndex: 'name',
    width: '22',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: 'Mobile',
    debugtype: 'string_china_mobile_phone',
    dataIndex: 'mobile',
    width: '15',
    render: (text, record) => renderTextCell(text, record),
  },
  {
    title: 'Last Update Time',
    dataIndex: 'lastUpdateTime',
    render: (text, record) => renderDateTimeCell(text, record),
  },
  {
    title: 'Platform',
    dataIndex: 'platform',
    render: (text, record) => renderReferenceCell(text, record),
  },
];

const fieldLabels = {
  id: 'Id',
  name: 'Name',
  mobile: 'Mobile',
  lastUpdateTime: 'Last Update Time',
  platform: 'Platform',
};

const ProfileBase = { menuData, displayColumns, fieldLabels };
export default ProfileBase;

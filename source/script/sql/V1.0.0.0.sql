SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_camerastateall
-- ----------------------------
DROP TABLE IF EXISTS `tbl_camerastateall`;

create table tbl_camerastateall AS
select 
  t.xjbh as SZ_GISCODE,
  0 as UI_ENABLE,
  0 as UI_RECORD_FLAG,
  0 as UI_RECORD_STATE,
	0 as UI_ACCESS_MODE,
	0 as UBI_UPDATE_TIME
 from tbl_sxj t;



-- ----------------------------
-- Table structure for tbl_devstatehistory_all
-- ----------------------------
DROP TABLE IF EXISTS `tbl_devstatehistory_all`;
CREATE TABLE `tbl_devstatehistory_all` (
  `UBI_LOGIC_ID` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `UI_EVENT_TYPE` int(11) unsigned NOT NULL COMMENT '事件类型：（后续可能扩展）\r\n1:相机离线\r\n2:离线恢复\r\n3:存储码流断开30秒+\r\n4:存储码流恢复\r\n',
  `UI_EVENT_DESC` char(255) DEFAULT '',
  `UBI_TIME` bigint(20) unsigned NOT NULL COMMENT '单位：秒 1970年1月日至今秒数',
  `SZ_GISCODE` char(50) NOT NULL COMMENT '国标编号',
  `UI_DEV_TYPE` int(11) unsigned NOT NULL COMMENT '设备类型：1 摄像机 2 未定义',
  `UI_ACCESS_MODE` int(11) unsigned NOT NULL COMMENT '摄像机接入模式：（后续可能扩展）\r\n1.平台接入相机 2:国标对接相机\r\n',
  PRIMARY KEY (`UBI_LOGIC_ID`),
  UNIQUE KEY `UBI_LOGIC_ID` (`UBI_LOGIC_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=gbk ROW_FORMAT=COMPACT;

INSERT INTO `tbl_devstatehistory_all` VALUES ('49', '1', '1', '1474027820', '15020000001320800020', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('50', '1', '1', '1474027820', '15020000001320800021', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('51', '1', '1', '1474027820', '15020000001320800022', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('52', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('53', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('54', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('55', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('56', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('57', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('58', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('59', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('60', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('61', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('62', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('63', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('64', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('65', '1', '1', '1474027820', '15020000001320800023', '1', '1');
INSERT INTO `tbl_devstatehistory_all` VALUES ('66', '1', '1', '1474027820', '15020000001320800023', '1', '1');




-- ----------------------------
-- Table structure for tbl_stateconfig
-- ----------------------------
DROP TABLE IF EXISTS `tbl_stateconfig`;
CREATE TABLE `tbl_stateconfig` (
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `tbl_stateconfig` VALUES ('driverClass', 'com.mysql.jdbc.Driver', null);
INSERT INTO `tbl_stateconfig` VALUES ('jdbcUrl', 'jdbc:mysql://localhost:3306/mvp10', null);
INSERT INTO `tbl_stateconfig` VALUES ('user', 'root', null);
INSERT INTO `tbl_stateconfig` VALUES ('password', '123456', null);
INSERT INTO `tbl_stateconfig` VALUES ('threadPoolSize', '5', '同步的线程数');
INSERT INTO `tbl_stateconfig` VALUES ('updateTimeInterval', '10000', '隔多长时间同步一次');
INSERT INTO `tbl_stateconfig` VALUES ('syncTime', '2016-09-19 14:47:21', '从什么时间开始同步');


create or replace view view_camerastate_all
as
SELECT
	t.xjbh as 'v_xjbh', /*相机编号*/
  t.xjmc as 'v_xjmc',  /*摄像机名称*/
  t.ipdz as 'v_ipdz', /* IP地址 */
 	t.mac as 'v_mac', /*MAC地址 */
	(case s.UI_ENABLE when 1 then '在线' else '离线' end) as 'v_online', /*在线状态*/
  '未知' as 'v_isStore', /*是否录像*/
	(case s.UI_RECORD_STATE when 1 then '正常' else '断开' end)  'v_store_state', /*录像状态*/
   s.UBI_UPDATE_TIME 'v_updateTime1', /*时间*/
   (FROM_UNIXTIME(s.UBI_UPDATE_TIME, '%Y-%m-%d %T' )) as 'v_updateTime',
  /*'v_xzqh',*/ /*行政区划*/
	(select w.dy from tbl_xzqhqjbh w where w.dm = t.gb_quj ) as 'v_xzqh',
   t.glbm as 'v_glbm', /*管理部门*/
	(select x.`value` from tbl_sxjlx x where x.op = t.xjlx) as 'v_xjlx', /*相机类型*/
  (case t.sfkk when 1 then '是' else '否' end) as 'v_sfkk',   /*是否可控*/
   (case t.yt when 1 then '治安' when 2 then '交通' when 3 then '重点部位' end) as 'v_yt', /*用途*/
   (case t.qybz when 1 then '启用' else '停用' end) as 'v_qybz', /*启用标志*/
   (case t.zgd when 1 then '是' else '否' end) as 'v_zgd', /*制高点*/
	 t.sccs as 'v_xjcs', /*相机厂商*/
    (select w.dwmc from tbl_dwxx w where w.id = t.dwxxid ) as 'v_dwmc',  /*点位名称*/
    (select l.mc from tbl_lkxx l where l.id = t.lkxxid ) as 'v_lkmc',  /*路口名称*/
   (case t.jttw when 0 then '不支持' when 1 then '不支持' end) as 'v_twkg',  /*透雾开关*/
   t.gisjd  as 'v_gd', /*经度*/
   t.giswd as 'v_wd', /*纬度*/
   t.azrq as 'v_azrq', /*安装日期*/
   t.bzqz as 'v_bzqz', /*保质期至*/
   t.jsdw as 'v_jsdw', /*承建单位*/
   t.yt_htbh as 'v_yt_htbh', /*合同编号*/
   t.jt_htbh as 'v_jt_htbh', 
   t.gcbh as 'v_gcbh',  /*工程信息编号*/
   t.zrr_bm as 'v_zrbm', /*设备责任部门*/
   t.zrr_lxdh as 'v_zrr_lxdh', /* 设备责任部门责任人联系电话 */
   t.jydw as 'v_jydw',  /*检验单位*/
   t.lrr as 'v_lrr'  /*录入人*/
FROM
	tbl_sxj t,
	tbl_camerastateall s
WHERE
	t.xjbh = s.SZ_GISCODE;



create or replace view view_devstatehistory_all
as
SELECT t.xjbh as 'v_xjbh', /*相机编号*/
  t.xjmc as 'v_xjmc',  /*摄像机名称*/
  t.ipdz as 'v_ipdz', /* IP地址 */
 	t.mac as 'v_mac', /*MAC地址 */
  (case s.UI_EVENT_TYPE when 1 then '相机离线' when 2 then '离线恢复' when 3  then '存储码流断开30秒+' else '存储码流恢复' end) as 'v_event_type', /*在线状态*/
  '未知' as 'v_isStore', /*是否录像*/
   s.UBI_TIME 'v_updateTime1', /*时间*/
   (FROM_UNIXTIME(s.UBI_TIME, '%Y-%m-%d %T' )) as 'v_updateTime',
  /*'v_xzqh',*/ /*行政区划*/
	(select w.dy from tbl_xzqhqjbh w where w.dm = t.gb_quj ) as 'v_xzqh',
   t.glbm as 'v_glbm', /*管理部门*/
	(select x.`value` from tbl_sxjlx x where x.op = t.xjlx) as 'v_xjlx', /*相机类型*/
  (case t.sfkk when 1 then '是' else '否' end) as 'v_sfkk',   /*是否可控*/
   (case t.yt when 1 then '治安' when 2 then '交通' when 3 then '重点部位' end) as 'v_yt', /*用途*/
   (case t.qybz when 1 then '启用' else '停用' end) as 'v_qybz', /*启用标志*/
   (case t.zgd when 1 then '是' else '否' end) as 'v_zgd', /*制高点*/
	 t.sccs as 'v_xjcs', /*相机厂商*/
    (select w.dwmc from tbl_dwxx w where w.id = t.dwxxid ) as 'v_dwmc',  /*点位名称*/
    (select l.mc from tbl_lkxx l where l.id = t.lkxxid ) as 'v_lkmc',  /*路口名称*/
   (case t.jttw when 0 then '不支持' when 1 then '不支持' end) as 'v_twkg',  /*透雾开关*/
   t.gisjd  as 'v_gd', /*经度*/
   t.giswd as 'v_wd', /*纬度*/
   t.azrq as 'v_azrq', /*安装日期*/
   t.bzqz as 'v_bzqz', /*保质期至*/
   t.jsdw as 'v_jsdw', /*承建单位*/
   t.yt_htbh as 'v_yt_htbh', /*合同编号*/
   t.jt_htbh as 'v_jt_htbh', 
   t.gcbh as 'v_gcbh',  /*工程信息编号*/
   t.zrr_bm as 'v_zrbm', /*设备责任部门*/
   t.zrr_lxdh as 'v_zrr_lxdh', /* 设备责任部门责任人联系电话 */
   t.jydw as 'v_jydw',  /*检验单位*/
   t.lrr as 'v_lrr'  /*录入人*/
FROM
	tbl_sxj t,
	tbl_devstatehistory_all s
WHERE
	t.xjbh = s.SZ_GISCODE;



create or replace view view_mvpserver as
select DISTINCT t.fwqdz from tbl_sxj t ;
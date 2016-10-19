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
	`t`.`xjbh` AS `v_xjbh`,
	`t`.`xjmc` AS `v_xjmc`,
	`t`.`ipdz` AS `v_ipdz`,
	`t`.`mac` AS `v_mac`,
	(
		CASE `s`.`UI_ENABLE`
		WHEN 1 THEN
			'在线'
		ELSE
			'离线'
		END
	) AS `v_online`,
	'未知' AS `v_isStore`,
	(
		CASE `s`.`UI_RECORD_STATE`
		WHEN 1 THEN
			'正常'
		ELSE
			'断开'
		END
	) AS `v_store_state`,
	`s`.`UBI_UPDATE_TIME` AS `v_updateTime1`,
	date_format(
		from_unixtime(`s`.`UBI_UPDATE_TIME`),
		'%Y-%m-%d %T'
	) AS `v_updateTime`,
	(
		SELECT
			`w`.`dy`
		FROM
			`tbl_xzqhqjbh` `w`
		WHERE
			(`w`.`dm` = `t`.`gb_quj`)
	) AS `v_xzqh`,
	`t`.`glbm` AS `v_glbm`,
	(
		SELECT
			`x`.`dmsm`
		FROM
			`tbl_sxjlx` `x`
		WHERE
			(`x`.`sxbh` = `t`.`xjlx`)
	) AS `v_xjlx`,
	(
		CASE `t`.`sfkk`
		WHEN 1 THEN
			'是'
		ELSE
			'否'
		END
	) AS `v_sfkk`,
	(
		CASE `t`.`yt`
		WHEN 1 THEN
			'治安'
		WHEN 2 THEN
			'交通'
		WHEN 3 THEN
			'重点部位'
		END
	) AS `v_yt`,
	(
		CASE `t`.`qybz`
		WHEN 1 THEN
			'启用'
		ELSE
			'停用'
		END
	) AS `v_qybz`,
	(
		CASE `t`.`zgd`
		WHEN 1 THEN
			'是'
		ELSE
			'否'
		END
	) AS `v_zgd`,
	`t`.`sccs` AS `v_xjcs`,
	(
		SELECT
			`w`.`dwmc`
		FROM
			`tbl_dwxx` `w`
		WHERE
			(`w`.`id` = `t`.`dwxxid`)
	) AS `v_dwmc`,
	(
		SELECT
			`l`.`mc`
		FROM
			`tbl_lkxx` `l`
		WHERE
			(`l`.`id` = `t`.`lkxxid`)
	) AS `v_lkmc`,
	(
		CASE `t`.`jttw`
		WHEN 0 THEN
			'不支持'
		WHEN 1 THEN
			'不支持'
		END
	) AS `v_twkg`,
	`t`.`gisjd` AS `v_gd`,
	`t`.`giswd` AS `v_wd`,
	`t`.`azrq` AS `v_azrq`,
	`t`.`bzqz` AS `v_bzqz`,
	`t`.`jsdw` AS `v_jsdw`,
	`t`.`yt_htbh` AS `v_yt_htbh`,
	`t`.`jt_htbh` AS `v_jt_htbh`,
	`t`.`gcbh` AS `v_gcbh`,
	`t`.`zrr_bm` AS `v_zrbm`,
	`t`.`zrr_lxdh` AS `v_zrr_lxdh`,
	`t`.`jydw` AS `v_jydw`,
	`t`.`lrr` AS `v_lrr`
FROM
	(
		`tbl_sxj` `t`
		JOIN `tbl_camerastateall` `s`
	)
WHERE
	(
		(
			`t`.`xjbh` = `s`.`SZ_GISCODE`
		)
		AND (`t`.`xjbh` <> 'N/A')
	);


create or replace view view_devstatehistory_all
as
SELECT
	`t`.`xjbh` AS `v_xjbh`,
	`t`.`xjmc` AS `v_xjmc`,
	`t`.`ipdz` AS `v_ipdz`,
	`t`.`mac` AS `v_mac`,
	(
		CASE `s`.`UI_EVENT_TYPE`
		WHEN 1 THEN
			'相机离线'
		WHEN 2 THEN
			'离线恢复'
		WHEN 3 THEN
			'存储码流断开30秒+'
		ELSE
			'存储码流恢复'
		END
	) AS `v_event_type`,
	'未知' AS `v_isStore`,
	`s`.`UBI_TIME` AS `v_updateTime1`,
	date_format(
		from_unixtime(`s`.`UBI_TIME`),
		'%Y-%m-%d %T'
	) AS `v_updateTime`,
	(
		SELECT
			`w`.`dy`
		FROM
			`tbl_xzqhqjbh` `w`
		WHERE
			(`w`.`dm` = `t`.`gb_quj`)
	) AS `v_xzqh`,
	`t`.`glbm` AS `v_glbm`,
	(
		SELECT
			`x`.`dmsm`
		FROM
			`tbl_sxjlx` `x`
		WHERE
			(`x`.`sxbh` = `t`.`xjlx`)
	) AS `v_xjlx`,
	(
		CASE `t`.`sfkk`
		WHEN 1 THEN
			'是'
		ELSE
			'否'
		END
	) AS `v_sfkk`,
	(
		CASE `t`.`yt`
		WHEN 1 THEN
			'治安'
		WHEN 2 THEN
			'交通'
		WHEN 3 THEN
			'重点部位'
		END
	) AS `v_yt`,
	(
		CASE `t`.`qybz`
		WHEN 1 THEN
			'启用'
		ELSE
			'停用'
		END
	) AS `v_qybz`,
	(
		CASE `t`.`zgd`
		WHEN 1 THEN
			'是'
		ELSE
			'否'
		END
	) AS `v_zgd`,
	`t`.`sccs` AS `v_xjcs`,
	(
		SELECT
			`w`.`dwmc`
		FROM
			`tbl_dwxx` `w`
		WHERE
			(`w`.`id` = `t`.`dwxxid`)
	) AS `v_dwmc`,
	(
		SELECT
			`l`.`mc`
		FROM
			`tbl_lkxx` `l`
		WHERE
			(`l`.`id` = `t`.`lkxxid`)
	) AS `v_lkmc`,
	(
		CASE `t`.`jttw`
		WHEN 0 THEN
			'不支持'
		WHEN 1 THEN
			'不支持'
		END
	) AS `v_twkg`,
	`t`.`gisjd` AS `v_gd`,
	`t`.`giswd` AS `v_wd`,
	`t`.`azrq` AS `v_azrq`,
	`t`.`bzqz` AS `v_bzqz`,
	`t`.`jsdw` AS `v_jsdw`,
	`t`.`yt_htbh` AS `v_yt_htbh`,
	`t`.`jt_htbh` AS `v_jt_htbh`,
	`t`.`gcbh` AS `v_gcbh`,
	`t`.`zrr_bm` AS `v_zrbm`,
	`t`.`zrr_lxdh` AS `v_zrr_lxdh`,
	`t`.`jydw` AS `v_jydw`,
	`t`.`lrr` AS `v_lrr`
FROM
	(
		`tbl_sxj` `t`
		JOIN `tbl_devstatehistory_all` `s`
	)
WHERE
	(
		(
			`t`.`xjbh` = `s`.`SZ_GISCODE`
		)
		AND (`t`.`xjbh` <> 'N/A')
	);

create or replace view view_mvpserver as
select DISTINCT t.fwqdz from tbl_sxj t ;
/*
SQLyog Community v13.1.1 (64 bit)
MySQL - 10.1.37-MariaDB : Database - absensi
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`absensi` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `absensi`;

/*Table structure for table `absensi` */

DROP TABLE IF EXISTS `absensi`;

CREATE TABLE `absensi` (
  `id_absensi` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `tanggal` date DEFAULT NULL,
  `id_kelas` bigint(20) DEFAULT NULL,
  `rekap_absen` int(11) DEFAULT NULL,
  `nis_absensi` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_absensi`),
  KEY `FK3puh4cf7jfuqn24sqadpblmtb` (`id_kelas`),
  KEY `FK9v46u88pkrocpmi09l6ty4u61` (`rekap_absen`),
  KEY `FKjjri7el30ef95ynpi8vjssrh8` (`nis_absensi`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `absensi` */

insert  into `absensi`(`id_absensi`,`status`,`tanggal`,`id_kelas`,`rekap_absen`,`nis_absensi`) values 
(1,0,'2019-01-06',1,1,22673535);

/*Table structure for table `hibernate_sequence` */

DROP TABLE IF EXISTS `hibernate_sequence`;

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `hibernate_sequence` */

insert  into `hibernate_sequence`(`next_val`) values 
(3),
(3),
(3),
(3),
(1),
(1),
(1),
(1);

/*Table structure for table `kelas` */

DROP TABLE IF EXISTS `kelas`;

CREATE TABLE `kelas` (
  `id_kelas` bigint(20) NOT NULL AUTO_INCREMENT,
  `nama_kelas` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_kelas`)
) ENGINE=MyISAM AUTO_INCREMENT=1111 DEFAULT CHARSET=latin1;

/*Data for the table `kelas` */

insert  into `kelas`(`id_kelas`,`nama_kelas`,`version`) values 
(1,'10 IPA 1',0),
(2,'10 IPA 2',0),
(3,'10 IPA 3',0),
(4,'10 IPA 4',0),
(5,'10 IPA 5',0),
(6,'10 IPS 1',0),
(7,'10 IPS 2',0),
(8,'10 IPS 3',0),
(9,'10 IPS 4',0),
(10,'10 IPS 5',0),
(11,'11 IPA 1',0),
(12,'11 IPA 2',0);

/*Table structure for table `persistent_logins` */

DROP TABLE IF EXISTS `persistent_logins`;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `persistent_logins` */

/*Table structure for table `rekapitulasi` */

DROP TABLE IF EXISTS `rekapitulasi`;

CREATE TABLE `rekapitulasi` (
  `id_rekapitulasi` int(11) NOT NULL,
  `alpa` varchar(255) DEFAULT NULL,
  `hadir` int(11) DEFAULT NULL,
  `izin` varchar(255) DEFAULT NULL,
  `persentasi` float NOT NULL,
  `sakit` varchar(255) DEFAULT NULL,
  `semester` varchar(255) DEFAULT NULL,
  `tahun` int(11) DEFAULT NULL,
  `nis_rekap` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_rekapitulasi`),
  KEY `FKg43l0xuu2qj2o5bo6g879htb4` (`nis_rekap`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `rekapitulasi` */

/*Table structure for table `role` */

DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `role` */

insert  into `role`(`role_id`,`role`) values 
(1,'ADMIN'),
(2,'GURU');

/*Table structure for table `siswa` */

DROP TABLE IF EXISTS `siswa`;

CREATE TABLE `siswa` (
  `nis` int(11) NOT NULL AUTO_INCREMENT,
  `jk_siswa` varchar(255) DEFAULT NULL,
  `nama_siswa` varchar(255) NOT NULL,
  `nama_ortu` varchar(255) DEFAULT NULL,
  `no_ortu` varchar(255) DEFAULT NULL,
  `version` int(11) DEFAULT NULL,
  `id_kelas` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`nis`),
  KEY `FKlbyb85ft4vq05gp235a432rur` (`id_kelas`)
) ENGINE=MyISAM AUTO_INCREMENT=24562337 DEFAULT CHARSET=latin1;

/*Data for the table `siswa` */

insert  into `siswa`(`nis`,`jk_siswa`,`nama_siswa`,`nama_ortu`,`no_ortu`,`version`,`id_kelas`) values 
(22673535,'Laki-Laki','A Prabhu','Achmad Fajar','081375908790',0,1),
(22763521,'Laki-Laki','A. Budi Pranoto','Faried Joesoef','082145327887',0,1),
(22675430,'Perempuan','Aam Dewi Hamidah','Rifai Natanegara','082178908765',0,1),
(22456098,'Perempuan','Aarti Lohia','Slam Tahir','081345600980',0,1),
(23673536,'Laki-Laki','Abdul Hadi Ismail','Nugraha Djuanda','081768920808',0,1),
(23673537,'Laki-Laki','Aubrey Bobb','Lestari Rahayu','081356567887',0,1),
(23673538,'Laki-Laki','B. Daorpi Parlindungan','Subianto','081343456556',0,1),
(23673539,'Perempuan  ','Beatrice El','Virgan Triyanto','082157989877',0,1),
(23673540,'Perempuan','Belinda Natalia ','Bambang Panutomo','082145678998',0,1),
(23673541,'Perempuan','Betty Ang','Setiawan','081345679877',0,1),
(23673542,'Laki-Laki','Benny Tenges','Ben Morice','081567768998',0,1),
(23673543,'Perempuan','Bernadette Irawati','Benjamin Subrata','082215676589',0,1),
(23673544,'Perempuan','Cecilia Tejowarno','Chairul Tanjung','081787978990',0,1),
(23673545,'Laki-Laki','Cnadra Winoto','Robert Lukmantara','087656899080',0,1),
(23673546,'Laki-Laki','Danny Juwono','Dartojo Setyawan','082145546776',0,1),
(23673547,'Perempuan','Daswi Rayawang','Ben Rayawang','083456658909',0,1),
(23673548,'Perempuan ','East Miranda','John Pramono','081565763443',0,1),
(23673549,'Laki-Laki','Eddy Halim','Purwanto Lin','081345657890',0,1),
(23673550,'Laki-Laki','Fahmi Babra','Abdul Rahan','082134325665',0,1),
(23673551,'Laki-Laki','Gandhi Bend','Vhander Grover','086754673456',0,1),
(23673552,'Perempuan','Helen Wijaya','Ron Wijaya','082134238998',0,1),
(24562331,'Laki-Laki','Bayu Prasetyo','Adelina Sanjaya','082332435678',0,6),
(24562332,'Perempuan','Bellyna Budiman','Ben Budiman','082345656757',0,6),
(24562333,'Perempuan','Christina Harapan','Sandy Harapan','081232456570',0,6),
(24562334,'Laki-Laki','Christoper Tanuwijaya','Rendy Tanuwijaya','082354607680',0,6),
(24562335,'Laki-Laki','Daniel Podiman','Darjoto Podiman','082143437887',0,6),
(24562336,'Perempuan','Florence Subrata','Darmadi Subrata','082134567689',0,6),
(21562337,'Laki-Laki','Freddy Sumartono','Gan Sumartono','081243567876',0,6),
(21562338,'Laki-Laki','Gary Mirpuri','David Mirpuri','082167769089',0,6),
(21562339,'Perempuan','Geeta Yang','Gareth Yang','082343567867',0,6),
(21562340,'Laki-Laki','Hans Solicin','Hardi Solicin','081323235476',0,6),
(21562341,'Perempuan','Hirnawati','Husin Suliawan','082134123245',0,6),
(21562342,'Perempuan','Istini Budiono','Susanto Budiono','082132124567',0,6),
(21562343,'Laki-Laki','Jimmy Samantha','Rohn Samantha','081345676543',0,6),
(21562344,'Perempuan','Joecelin Haryanto','Rudy Haryanto','082198325434',0,6),
(21562345,'Perempuan','Kartini Fahmi','Putri Sedianto','081321564356',0,6),
(21562346,'Laki-Laki','Lambertus Somar','Hadi Somar','082356543221',0,6),
(21562347,'Perempuan','Metta Goenawan','Rusli Goenawan','082156876543',0,6),
(21562348,'Laki-Laki','Michael Euslim','Steven Euslim','082354326789',0,6),
(21562349,'Laki-Laki','Nico Krisatnto','Nio Kristanto','082345327651',0,6),
(21562350,'Perempuan','Putri Laksana','Martin Laksana','082345643121',0,6);

/*Table structure for table `smsgateway` */

DROP TABLE IF EXISTS `smsgateway`;

CREATE TABLE `smsgateway` (
  `id_sms` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(255) NOT NULL,
  `number` varchar(255) NOT NULL,
  PRIMARY KEY (`id_sms`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/*Data for the table `smsgateway` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `firstname` varchar(255) NOT NULL,
  `lastname` varchar(255) NOT NULL,
  `uname` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `active` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`firstname`,`lastname`,`uname`,`password`,`active`) values 
(1,'Guru',' ','guru','$2a$10$VsXpRMyM9AighhqPavRJ2erDN4is7ypLPoe59F3gYlBDB8qRzrW.S',1),
(2,'Kesiswaan',' ','kesiswaan','$2a$10$cmKaqnC9EZ9d3pcZwal1J.o5.LqGNnWtpUHx5oOYct63XODiPK3Fq',1);

/*Table structure for table `user_role` */

DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`),
  KEY `user_role_key` (`role_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `role_userrole` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`),
  CONSTRAINT `user_userrole` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_role` */

insert  into `user_role`(`user_id`,`role_id`) values 
(1,1),
(2,1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;


CREATE DATABASE king;

CREATE TABLE king.portfolio(
`id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'PK',
`name` varchar(255) NOT NULL COMMENT '포트폴리오 이름',
`created_at` datetime(6) NOT NULL COMMENT 'createdAt',
`updated_at` datetime(6) NOT NULL COMMENT 'updatedAt',
PRIMARY KEY (`id`),
KEY `portfolio_idx01` (`created_at`),
KEY `portfolio_idx02` (`updated_at`)
) ENGINE = InnoDB DEFAULT CHARSET =utf8;


CREATE TABLE king.portfolio_item(
`id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'PK',
`quantity` int(10) NOT NULL COMMENT '보유 수량',
`stock_id` bigint(10) NOT NULL COMMENT 'stock 엔티티 Id',
`purchase_price_sum` DECIMAL(16,2) NOT NULL COMMENT '주식 가치',
`portfolio_id` bigint(10) NOT NULL COMMENT 'portfolio 엔티티 Id',
`created_at` datetime(6) NOT NULL COMMENT 'createdAt',
`updated_at` datetime(6) NOT NULL COMMENT 'updatedAt',
PRIMARY KEY (`id`),
KEY `portfolio_item_idx01` (`created_at`),
KEY `portfolio_item_idx02` (`updated_at`),
KEY `portfolio_item_idx03` (`portfolio_id`),
KEY `portfolio_item_idx04` (`stock_id`,`portfolio_id`)
) ENGINE = InnoDB DEFAULT CHARSET =utf8;

CREATE TABLE king.portfolio_item_put_log(
`id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'PK',
`portfolio_item_id` bigint(10) NOT NULL COMMENT 'portfoliItem 엔티티 Id',
`work_type` varchar(10) NOT NULL COMMENT '이동 타입: 입금/출금/이자',
`put_quantity` int(10) NOT NULL COMMENT '수량',
`put_price_sum` DECIMAL(16,2) NOT NULL COMMENT '변동 금액',
`created_at` datetime(6) NOT NULL COMMENT 'created_at',
`updated_at` datetime(6) NOT NULL COMMENT 'updatedAt',
PRIMARY KEY (`id`),
KEY `portfolio_put_log_idx01` (`created_at`),
KEY `portfolio_put_log_idx02` (`updated_at`),
KEY `portfolio_put_log_idx03` (`portfolio_item_id`)
) ENGINE = InnoDB DEFAULT CHARSET =utf8;

CREATE TABLE king.stock(
`id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT 'PK',
`code` varchar(10) NOT NULL COMMENT '종목 코드',
`name` varchar(30) NOT NULL COMMENT '종목명',
`market` varchar(12) NOT NULL COMMENT '상장 마켓',
`price` DECIMAL(13,2) NOT NULL COMMENT '가격',
`dividend1` DECIMAL(10,2) COMMENT '1월 배당금',
`dividend2` DECIMAL(10,2) COMMENT '2월 배당금',
`dividend3` DECIMAL(10,2) COMMENT '3월 배당금',
`dividend4` DECIMAL(10,2) COMMENT '4월 배당금',
`dividend5` DECIMAL(10,2) COMMENT '5월 배당금',
`dividend6` DECIMAL(10,2) COMMENT '6월 배당금',
`dividend7` DECIMAL(10,2) COMMENT '7월 배당금',
`dividend8` DECIMAL(10,2) COMMENT '8월 배당금',
`dividend9` DECIMAL(10,2)COMMENT '9월 배당금',
`dividend10` DECIMAL(10,2) COMMENT '10월 배당금',
`dividend11` DECIMAL(10,2) COMMENT '11월 배당금',
`dividend12` DECIMAL(10,2) COMMENT '12월 배당금',
`volume` DECIMAL(10,2) COMMENT '거래량',
`created_at` datetime(6) NOT NULL COMMENT 'createdAt',
`updated_at` datetime(6) NOT NULL COMMENT 'updatedAt',
PRIMARY KEY (`id`),
KEY `stock_idx01` (`created_at`),
KEY `stock_idx02` (`updated_at`),
KEY `stock_idx03` (`code`)
) ENGINE = InnoDB DEFAULT CHARSET =utf8;

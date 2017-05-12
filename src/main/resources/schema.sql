CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `corporation` varchar(20) NOT NULL,
  `api_key` varchar(512) NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `deal` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `description` text NOT NULL,
  `type` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `display_price` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `price_unit` varchar(5) NOT NULL,
  `sale_start_at` datetime NOT NULL,
  `sale_end_at` datetime NOT NULL,
  `information_json` text NOT NULL,
  `image_json` text NOT NULL,
  `thumbnail_json` text NOT NULL,
  `display` varchar(1) NOT NULL DEFAULT 'N',
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `deal_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `deal_id` bigint(20) NOT NULL,
  `name` varchar(200) NOT NULL,
  `description` text NOT NULL,
  `type` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `cancel_type` varchar(10) NOT NULL,
  `display_price` int(11) NOT NULL,
  `price` int(11) NOT NULL,
  `price_unit` varchar(5) NOT NULL,
  `information_json` text NOT NULL,
  `image_json` text NOT NULL,
  `thumbnail_json` text NOT NULL,
  `sort` int(11) NOT NULL,
  `display` varchar(1) NOT NULL DEFAULT 'N',
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_DEAL_ID` (`deal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `deal_option_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `item_id` bigint(20) NOT NULL,
  `option_id` bigint(20) NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_ITEM_ID` (`item_id`),
  KEY `IDX_OPTION_ID` (`option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `type` varchar(10) NOT NULL,
  `sale_price` int(11) NOT NULL,
  `cost_price` int(11) NOT NULL,
  `deleted` varchar(1) NOT NULL DEFAULT 'N',
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `order` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` bigint(20) NOT NULL,
  `client_order_id` bigint(20) NOT NULL,
  `customer_id` bigint(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `price` int(11) NOT NULL,
  `deal_ids` text NOT NULL,
  `ordered_at` datetime NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `order_option` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` bigint(20) NOT NULL,
  `order_id` bigint(20) NOT NULL,
  `deal_id` bigint(20) NOT NULL,
  `deal_option_id` bigint(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `cancel_status` varchar(10) NOT NULL,
  `price` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_DEAL_ID` (`deal_id`),
  KEY `IDX_DEAL_OPTION_ID` (`deal_option_id`),
  KEY `IDX_ORDER_ID` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `order_item` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `client_id` bigint(20) NOT NULL,
  `option_id` bigint(20) NOT NULL,
  `title` varchar(100) NOT NULL,
  `type` varchar(10) NOT NULL,
  `status` varchar(10) NOT NULL,
  `cancel_status` varchar(10) NOT NULL,
  `sale_price` int(11) NOT NULL,
  `cost_price` int(11) NOT NULL,
  `created_at` datetime DEFAULT NULL,
  `updated_at` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_OPTION_ID` (`option_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `usable_item` (
  `id` bigint(20) NOT NULL,
  `stock` int(11) NOT NULL,
  `usable_count` int(11) NOT NULL,
  `available_end_at` datetime NOT NULL,
  `available_start_at` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE IF NOT EXISTS `usable_order_item` (
  `id` bigint(20) NOT NULL,
  `item_id` bigint(20) NOT NULL,
  `usable_count` int(11) NOT NULL,
  `used_count` int(11) NOT NULL,
  `available_end_at` datetime NOT NULL,
  `available_start_at` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `IDX_ITEM_ID` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
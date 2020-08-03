SELECT listing_id, name, city, room_type, accommodates, bathroom_count, bedroom_count, 
	bed_count, features, daily_price, review_count, rating_score, thumbnail_url, listing_url
FROM airbnb_listing 
		INNER JOIN location_detail USING(listing_id)
		INNER JOIN room_detail USING(listing_id)
		INNER JOIN reservation_detail USING(listing_id)
        INNER JOIN review_detail USING(listing_id)
        INNER JOIN url_detail USING(listing_id)
WHERE (? IS NULL OR LOWER(name) LIKE LOWER(?))
		AND (? IS NULL OR zip_code = ?)
		AND (? IS NULL OR city = ?)
		AND (? IS NULL OR country = ?)
		AND (? IS NULL OR daily_price <= ?)
		AND (? IS NULL OR daily_price >= ?)
		AND (? IS NULL OR cancellation_policy = ?)
		AND (? IS NULL OR room_type = ?)
		AND (? IS NULL OR accommodates >= ?)
		AND (? IS NULL OR bathroom_count >= ?)
		AND (? IS NULL OR bedroom_count >= ?)
		AND (? IS NULL OR bed_count >= ?);
-- Find yelp listing that is open and within 10km of selected listing geometry
-- '10022363', 'Wicker Park, Chicago, IL 60642, United States', 'Chicago', 'IL', '60642',
-- 'US', 'United States', '41.906390599', '-87.666130392'

SELECT distance, business_id, name, address, city, state, postal_code, stars, review_count, is_open, categories
FROM (
	SELECT 
		ST_Distance_Sphere(POINT(b.longitude, b.latitude), POINT(?, ?)) AS distance, 
		b.*
	FROM business_overview b
) business_with_distance 
WHERE distance <= ?
ORDER BY distance ASC;
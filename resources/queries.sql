-- name: users-by-country
-- Counts the users in a given country.
SELECT count(*) AS count
FROM users
WHERE country_code = :country_code

-- name: user-count
-- Counts all the users.
SELECT count(*) AS count
FROM users

-- name: get-users
-- Get all users
SELECT * FROM users

-- name: get-user*
-- Get user by id
SELECT * FROM users
WHERE id = :id

-- name: add-user!
-- Adds a new user to the users table
INSERT INTO users
(id, pass, first_name, last_name, country_code)
VALUES
(:id, :pass, :first_name, :last_name, :country_code)

-- name: delete-users!
-- delete all users
DELETE FROM users

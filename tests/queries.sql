-- Retrieve all posts, first result is the latest
SELECT * FROM POSTS ORDER BY postDate DESC-- Add LIMIT + int for a maximum amount

-- Retrive all posts with their comments, date formated and users
SELECT COMMENTS.ID, COMMENTS.content, DATE_FORMAT(COMMENTS.postDate,"%D, %M %Y à %k:%i"), USERS.pseudo
FROM COMMENTS 
JOIN COMMENT_BY ON COMMENTS.ID = COMMENT_BY.commentID
JOIN POSTS ON COMMENT_BY.postID = POSTS.ID
JOIN USERS ON USERS.ID = COMMENTS.userID
WHERE POSTS.ID = :id
AND COMMENTS.status = 1
ORDER BY COMMENTS.postDate DESC

-- Update a comment
UPDATE COMMENTS SET content = :content
WHERE ID = :id
AND status = 1

-- "Delete" a comment
UPDATE COMMENTS SET status = !status
WHERE ID = :id

-- "Delete" a user
UPDATE USERS SET alive = !alive
WHERE (ID = :id OR pseudo = :pseudo)

-- Insert a user
INSERT INTO USERS(`pseudo`,`mail`,`password`) VALUES(:p,:m,:pass)

-- Insert a post
INSERT INTO POSTS(`name`,`content`) VALUES(:n,:c)

-- Insert a comment
INSERT INTO COMMENTS(`content`) VALUES(:c)

-- Like a post
INSERT INTO LIKES(`postID`,`userID`) VALUES(:p,:u)

-- unlike a post 
DELETE FROM LIKES WHERE postID = :p AND userID = unlike

-- get a post likes
SELECT COUNT(userID) FROM LIKES WHERE postID = :p

-- send a message
INSERT INTO MESSAGES(`message`,`expeditorID`,`receiverID`) VALUES (:m,:e,:r)

-- Link a comment to a post 
INSERT INTO COMMENT_BY(`commentID`,`postID`) VALUES(:c,:p)
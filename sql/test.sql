SELECT
    board_idx,
    title,
    hit_cnt,
    DATE_FORMAT(created_datetime, '%Y.%m.%d %H:%i:%s') AS created_datetime
FROM
    t_board
WHERE
    deleted_yn = 'N'
ORDER BY 
    board_idx DESC;
    
-- 게시판 테스트를 위한 최초 값 등록
INSERT INTO t_board
(
    title,
    contents,
    creator_id,
    created_datetime
)
VALUES
(
    'first title',
    'first contents',
    'admin',
    NOW()
);

INSERT INTO t_board
(
    title,
    contents,
    creator_id,
    created_datetime
)
VALUES
(
    '한글 검증',
    '첫 한글 쓰기',
    'admin',
    NOW()
);
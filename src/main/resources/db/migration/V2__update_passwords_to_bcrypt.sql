-- 기존 사용자의 비밀번호를 BCrypt로 업데이트
-- 비밀번호가 'password'인 경우 BCrypt로 인코딩된 값으로 업데이트
UPDATE users SET password = '$2a$10$N.zmdr9k7uOCQb376NoUnuTJ8iAt6Z5EHsM8lE9lBOsl7iAt6Z5EHsM8' WHERE password = 'password';

-- 비밀번호가 'admin'인 경우 BCrypt로 인코딩된 값으로 업데이트
UPDATE users SET password = '$2a$10$8K1p/a0dL1LXMIgoEDFrwO.1V1qJ1qJ1qJ1qJ1qJ1qJ1qJ1qJ1qJ1q' WHERE password = 'admin'; 
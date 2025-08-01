# [level 3] 없어진 기록 찾기 - 59042 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/59042) 

### 성능 요약

메모리: 0.0 MB, 시간: 0.00 ms

### 구분

코딩테스트 연습 > JOIN

### 채점결과

Empty

### 제출 일자

2025년 07월 30일 13:55:30

### 문제 설명

<p><code>ANIMAL_INS</code> 테이블은 동물 보호소에 들어온 동물의 정보를 담은 테이블입니다. <code>ANIMAL_INS</code> 테이블 구조는 다음과 같으며, <code>ANIMAL_ID</code>, <code>ANIMAL_TYPE</code>, <code>DATETIME</code>, <code>INTAKE_CONDITION</code>, <code>NAME</code>, <code>SEX_UPON_INTAKE</code>는 각각 동물의 아이디, 생물 종, 보호 시작일, 보호 시작 시 상태, 이름, 성별 및 중성화 여부를 나타냅니다.</p>
<table class="table">
        <thead><tr>
<th>NAME</th>
<th>TYPE</th>
<th>NULLABLE</th>
</tr>
</thead>
        <tbody><tr>
<td>ANIMAL_ID</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
<tr>
<td>ANIMAL_TYPE</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
<tr>
<td>DATETIME</td>
<td>DATETIME</td>
<td>FALSE</td>
</tr>
<tr>
<td>INTAKE_CONDITION</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
<tr>
<td>NAME</td>
<td>VARCHAR(N)</td>
<td>TRUE</td>
</tr>
<tr>
<td>SEX_UPON_INTAKE</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p><code>ANIMAL_OUTS</code> 테이블은 동물 보호소에서 입양 보낸 동물의 정보를 담은 테이블입니다. <code>ANIMAL_OUTS</code> 테이블 구조는 다음과 같으며, <code>ANIMAL_ID</code>, <code>ANIMAL_TYPE</code>, <code>DATETIME</code>, <code>NAME</code>, <code>SEX_UPON_OUTCOME</code>는 각각 동물의 아이디, 생물 종, 입양일, 이름, 성별 및 중성화 여부를 나타냅니다. <code>ANIMAL_OUTS</code> 테이블의 <code>ANIMAL_ID</code>는 <code>ANIMAL_INS</code>의 <code>ANIMAL_ID</code>의 외래 키입니다.</p>
<table class="table">
        <thead><tr>
<th>NAME</th>
<th>TYPE</th>
<th>NULLABLE</th>
</tr>
</thead>
        <tbody><tr>
<td>ANIMAL_ID</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
<tr>
<td>ANIMAL_TYPE</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
<tr>
<td>DATETIME</td>
<td>DATETIME</td>
<td>FALSE</td>
</tr>
<tr>
<td>NAME</td>
<td>VARCHAR(N)</td>
<td>TRUE</td>
</tr>
<tr>
<td>SEX_UPON_OUTCOME</td>
<td>VARCHAR(N)</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p>천재지변으로 인해 일부 데이터가 유실되었습니다. 입양을 간 기록은 있는데, 보호소에 들어온 기록이 없는 동물의 ID와 이름을 ID 순으로 조회하는 SQL문을 작성해주세요. </p>

<h5>예시</h5>

<p>예를 들어, <code>ANIMAL_INS</code> 테이블과 <code>ANIMAL_OUTS</code> 테이블이 다음과 같다면</p>

<p><code>ANIMAL_INS</code></p>
<table class="table">
        <thead><tr>
<th>ANIMAL_ID</th>
<th>ANIMAL_TYPE</th>
<th>DATETIME</th>
<th>INTAKE_CONDITION</th>
<th>NAME</th>
<th>SEX_UPON_INTAKE</th>
</tr>
</thead>
        <tbody><tr>
<td>A352713</td>
<td>Cat</td>
<td>2017-04-13 16:29:00</td>
<td>Normal</td>
<td>Gia</td>
<td>Spayed Female</td>
</tr>
<tr>
<td>A350375</td>
<td>Cat</td>
<td>2017-03-06 15:01:00</td>
<td>Normal</td>
<td>Meo</td>
<td>Neutered Male</td>
</tr>
</tbody>
      </table>
<p><code>ANIMAL_OUTS</code></p>
<table class="table">
        <thead><tr>
<th>ANIMAL_ID</th>
<th>ANIMAL_TYPE</th>
<th>DATETIME</th>
<th>NAME</th>
<th>SEX_UPON_OUTCOME</th>
</tr>
</thead>
        <tbody><tr>
<td>A349733</td>
<td>Dog</td>
<td>2017-09-27 19:09:00</td>
<td>Allie</td>
<td>Spayed Female</td>
</tr>
<tr>
<td>A352713</td>
<td>Cat</td>
<td>2017-04-25 12:25:00</td>
<td>Gia</td>
<td>Spayed Female</td>
</tr>
<tr>
<td>A349990</td>
<td>Cat</td>
<td>2018-02-02 14:18:00</td>
<td>Spice</td>
<td>Spayed Female</td>
</tr>
</tbody>
      </table>
<p><code>ANIMAL_OUTS</code> 테이블에서</p>

<ul>
<li>Allie의 ID는 <code>ANIMAL_INS</code>에 없으므로, Allie의 데이터는 유실되었습니다.</li>
<li>Gia의 ID는 <code>ANIMAL_INS</code>에 있으므로, Gia의 데이터는 유실되지 않았습니다.</li>
<li>Spice의 ID는 <code>ANIMAL_INS</code>에 없으므로, Spice의 데이터는 유실되었습니다.</li>
</ul>

<p>따라서 SQL문을 실행하면 다음과 같이 나와야 합니다. </p>
<table class="table">
        <thead><tr>
<th>ANIMAL_ID</th>
<th>NAME</th>
</tr>
</thead>
        <tbody><tr>
<td>A349733</td>
<td>Allie</td>
</tr>
<tr>
<td>A349990</td>
<td>Spice</td>
</tr>
</tbody>
      </table>
<hr>

<p>본 문제는 <a href="https://www.kaggle.com/aaronschlegel/austin-animal-center-shelter-intakes-and-outcomes" target="_blank" rel="noopener">Kaggle의 "Austin Animal Center Shelter Intakes and Outcomes"</a>에서 제공하는 데이터를 사용하였으며 <a href="https://opendatacommons.org/licenses/odbl/1.0/" target="_blank" rel="noopener">ODbL</a>의 적용을 받습니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges
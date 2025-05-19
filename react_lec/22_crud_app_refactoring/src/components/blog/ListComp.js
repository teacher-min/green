import { useEffect, useState } from 'react';
import { useSearchParams } from 'react-router-dom';
import { getBlogList } from '../../api/blogAPI';
import CustomNavigate from '../../hooks/CustomNavigate';
import PageComp from '../common/PageComp';

const ListComp = () => {

  // 페이지 이동 함수
  const { goToDetailPage, goToListPage } = CustomNavigate();

  // serverData 객체 선언
  const [serverData, setServerData] = useState({
    status: 0,
    message: '',
    results: {
      blogList: [],
      pageList: [],
      pageDto: {},
    }
  })

  // useSearchParams() : Query String(쿼리 스트링)으로 전달되는 요청 파라미터 처리
  const [ queryParams ] = useSearchParams();
  const page = !queryParams.get('page') ? 1 : parseInt(queryParams.get('page'));  // 요청 파라미터 page가 없으면 page=1 사용
  const size = !queryParams.get('size') ? 2 : parseInt(queryParams.get('size'));  // 요청 파라미터 size가 없으면 size=2 사용
  const sort = !queryParams.get('sort') ? 'id,desc' : queryParams.get('sort');    // 요청 파라미터 sort가 없으면 sort=id,desc 사용

  // useEffect() : 최초 렌더링 시 또는 page/size/sort 중 하나가 변하면 블로그 목록 조회
  useEffect(() => {
    getBlogList({ page, size, sort })
      .then(jsonData => {
        setServerData(jsonData);
      })
  }, [page, size, sort]);

  return (
    <div>
      <table border="1">
        <thead>
          <tr>
            <td>제목</td>
            <td>작성일시</td>
          </tr>
        </thead>
        <tbody>
          {
            serverData.results.blogList.length === 0 ?
            <></> :
            serverData.results.blogList.map(blog => 
              <tr key={blog.id}>
                <td>
                  <span onClick={() => { goToDetailPage(blog.id) }}>{blog.title}</span>
                </td>
                <td>{blog.createDt.replace('T', ' ')}</td>
              </tr>
            )
          }
        </tbody>
        <tfoot>
          <tr>
            <td colSpan={2}>
              <PageComp serverData={serverData} goToListPage={goToListPage} size={size} sort={sort} />
            </td>
          </tr>
        </tfoot>
      </table>
    </div>
  );

};

export default ListComp;
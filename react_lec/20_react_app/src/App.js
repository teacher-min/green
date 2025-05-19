import { BrowserRouter, Route, Routes } from "react-router-dom";
import BasicLayout from "./layouts/BasicLayout";
import Main from "./pages/Main";
import Blog from "./pages/Blog";
import Guestbook from "./pages/Guestbook";
import Store from "./pages/Store";

function App() {
  return (
    <>
      <BrowserRouter>
        <Routes>
          {/* 화면에 렌더링할 컴포넌트는 <BasicLayout/>이고, 이 <Route>의 자식(child)이 <BasicLayout/>의 <Outlet/>에 나타납니다. */}
          <Route element={<BasicLayout/>}>
            {/* 요청 주소에 따라 화면에 렌더링할 컴포넌트를 선택합니다. */}
            <Route path="/" element={<Main/>}/>
            <Route path="/main" element={<Main/>}/>
            <Route path="/blogs" element={<Blog/>}/>
            <Route path="/guestbooks" element={<Guestbook/>}/>
            <Route path="/stores" element={<Store/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
    </>
  );
}

export default App;



const Navbar = ({ user }) => {
  return (
    <nav style={{ padding: "10px", background: "#007bff", color: "#fff" }}>
      <span style={{ fontWeight: "bold", fontSize: "18px" }}>
        Office Monitoring System
      </span>
      <div style={{ float: "right" }}>
        {user ? (
          <a href="/login" style={{ color: "#fff", marginLeft: "20px" }}>
            Вийти
          </a>
        ) : (
          <>
            <a href="/login" style={{ color: "#fff", marginLeft: "20px" }}>
              Увійти
            </a>
            <a href="/register" style={{ color: "#fff", marginLeft: "20px" }}>
              Реєстрація
            </a>
          </>
        )}
      </div>
    </nav>
  );
};

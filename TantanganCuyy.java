import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TantanganCuyy extends JFrame {

    private CardLayout layoutHalaman;
    private JPanel panelUtama;

    public TantanganCuyy() {
        // Pengaturan frame
        setTitle("Mas nya minta Loopy");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        layoutHalaman = new CardLayout();
        panelUtama = new JPanel(layoutHalaman);

        // Menambahkan panel
        panelUtama.add(buatHalamanLogin(), "Login");
        panelUtama.add(buatHalamanHome(), "Home");
        panelUtama.add(buatHalamanAbout(), "About");

        add(panelUtama);
        setLocationRelativeTo(null);
        layoutHalaman.show(panelUtama, "Login");
    }

    private JPanel buatHalamanLogin() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(new Color(255, 182, 193)); // Latar belakang pink muda

        JLabel labelUsername = new JLabel("Username:");
        labelUsername.setHorizontalAlignment(SwingConstants.CENTER);
        labelUsername.setForeground(Color.WHITE);

        JTextField teksUsername = new JTextField();
        JLabel labelPassword = new JLabel("Password:");
        labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
        labelPassword.setForeground(Color.WHITE);

        JPasswordField teksPassword = new JPasswordField();
        JCheckBox checkboxKebijakan = new JCheckBox("Saya setuju dengan kebijakan");
        checkboxKebijakan.setBackground(new Color(255, 182, 193));
        checkboxKebijakan.setForeground(Color.WHITE);

        JButton tombolLogin = new JButton("Login");
        tombolLogin.setBackground(new Color(255, 105, 180)); // Pink yang lebih terang
        tombolLogin.setForeground(Color.WHITE);

        tombolLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (teksUsername.getText().isEmpty() || new String(teksPassword.getPassword()).isEmpty()) {
                    JOptionPane.showMessageDialog(panel, "Username dan Password harus diisi!");
                } else if (!checkboxKebijakan.isSelected()) {
                    JOptionPane.showMessageDialog(panel, "Anda harus menyetujui kebijakan terlebih dahulu!");
                } else {
                    layoutHalaman.show(panelUtama, "Home");
                }
            }
        });

        panel.add(labelUsername);
        panel.add(teksUsername);
        panel.add(labelPassword);
        panel.add(teksPassword);
        panel.add(checkboxKebijakan);
        panel.add(tombolLogin);

        return panel;
    }

    private JPanel buatHalamanHome() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 182, 193)); // Pink muda

        JLabel labelSelamatDatang = new JLabel("Selamat datang di Halaman Utama!");
        labelSelamatDatang.setHorizontalAlignment(SwingConstants.CENTER);
        labelSelamatDatang.setForeground(Color.WHITE);

        ImageIcon mikuImage = new ImageIcon("c8af527f-123d-4ce9-b54e-bd3609fd93f0.jpg");
        Image scaledImage = mikuImage.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH); // Sesuaikan ukuran
        JLabel labelGambar = new JLabel(new ImageIcon(scaledImage));
        labelGambar.setHorizontalAlignment(SwingConstants.CENTER);

        // Menambahkan panel tombol di bawah
        JPanel panelTombol = new JPanel();
        panelTombol.setBackground(new Color(255, 182, 193));

        JButton tombolAbout = new JButton("About");
        tombolAbout.setBackground(new Color(255, 105, 180));
        tombolAbout.setForeground(Color.WHITE);
        tombolAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutHalaman.show(panelUtama, "About");
            }
        });

        JButton tombolHome = new JButton("Home");
        tombolHome.setBackground(new Color(255, 105, 180));
        tombolHome.setForeground(Color.WHITE);
        tombolHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutHalaman.show(panelUtama, "Home");
            }
        });

        panelTombol.add(tombolHome);
        panelTombol.add(tombolAbout);

        panel.add(labelSelamatDatang, BorderLayout.NORTH);
        panel.add(labelGambar, BorderLayout.CENTER);
        panel.add(panelTombol, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel buatHalamanAbout() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(255, 182, 193)); // Pink muda

        JLabel labelAbout = new JLabel("<html>Tentang Loopy:<br>Loopy adalah karakter dalam film Pororo<br>"
                + "sebenarnya dia mirip Xaviera.<br>Dia dikenal dengan kecantikan dan ke uwuannya<br>"
                + "dan ke coquette.<html>");
        labelAbout.setHorizontalAlignment(SwingConstants.CENTER);
        labelAbout.setForeground(Color.WHITE);

        // Menambahkan panel tombol di bawah
        JPanel panelTombol = new JPanel();
        panelTombol.setBackground(new Color(255, 182, 193));

        JButton tombolKembaliHome = new JButton("Home");
        tombolKembaliHome.setBackground(new Color(255, 105, 180)); // Pink terang
        tombolKembaliHome.setForeground(Color.WHITE);
        tombolKembaliHome.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutHalaman.show(panelUtama, "Home");
            }
        });

        JButton tombolKembaliAbout = new JButton("About");
        tombolKembaliAbout.setBackground(new Color(255, 105, 180)); // Pink terang
        tombolKembaliAbout.setForeground(Color.WHITE);
        tombolKembaliAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layoutHalaman.show(panelUtama, "About");
            }
        });

        panelTombol.add(tombolKembaliHome);
        panelTombol.add(tombolKembaliAbout);

        panel.add(labelAbout, BorderLayout.CENTER);
        panel.add(panelTombol, BorderLayout.SOUTH);

        return panel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new TantanganCuyy().setVisible(true);
        });
    }
}
